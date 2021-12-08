package Java_2.Lesson7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String name;

    public String getName(){
        return name;
    }

    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.name = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessages();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }

    public void authentication() throws IOException {
      while (true){
        String str = in.readUTF();
        if (str.startsWith("/auth")) {
            String[] parts = str.split("\\s+");
            String nick = myServer.getAuthorizationService().getNickByLoginPass(parts[1], parts[2]);
            if (nick != null) {
                if (!myServer.isNickBusy(nick)) {
                    sendMessages("/authok " + nick);
                    name = nick;
                    myServer.broadcastMsg(name + " зашел в чат");
                    myServer.subscribe(this);
                    return;
                } else {
                    sendMessages("Учетная запись уже используется");
                }
            } else {
                sendMessages("Неверный логин/пароль");
            }
          }
        }
      }

    public void readMessages() throws IOException {
          while (true) {
              String strFromClient = in.readUTF();
              System.out.println("Log/ " + name + " написал: " + strFromClient);
              if (strFromClient.equals("/end")) {
                  return;
              }
              if (strFromClient.startsWith("/w")){
                  String[] parts = strFromClient.split("\\s+");
                  String whom = parts[1];
                  String msg = strFromClient.substring(4 + whom.length());
                  if(myServer.sendPrivateMsg(whom, "Личное сообщение от " + name + ": " + msg)){
                      out.writeUTF("Личное сообщение для " + whom + ": " + msg);
                  }else{
                      out.writeUTF("Участник " + whom + " не в сети");
                  }
              }else{
                  myServer.broadcastMsg(name + ": " + strFromClient);
              }
          }
        }

    public void sendMessages(String msg){
          try{
            out.writeUTF(msg);
          }catch (IOException e){
            e.printStackTrace();
          }
    }

    public void closeConnection() {
          myServer.unsubscribe(this);
          myServer.broadcastMsg(name + " вышел из чата");
          try{
              in.close();
              out.close();
              socket.close();
          }catch (IOException e){
              e.printStackTrace();
          }
        }
  }
