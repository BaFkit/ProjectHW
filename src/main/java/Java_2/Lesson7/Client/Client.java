package Java_2.Lesson7.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends JFrame {

    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private final JTextField textField;
    private final JTextArea textArea;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    private String nick = "";

    public Client(){
        setBounds(600, 300, 500, 500);
        setTitle("Just Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        textArea = new JTextArea();
        textField = new JTextField();
        JButton button = new JButton("Enter");

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        panel.add(button, BorderLayout.EAST);
        panel.add(textField, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        button.addActionListener((e) -> {
            try {
                sendMessage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        textField.addActionListener((e) -> {
            try {
                sendMessage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    out.writeUTF("/end");
                    closeConnection();
                } catch (IOException | NullPointerException io) {
                    io.printStackTrace();
                }

            }
        });
        setVisible(true);
    }

    public void sendMessage() throws IOException {
        String message = textField.getText().trim();
        if (!message.isEmpty()) {
            textField.setText("");
            textField.grabFocus();
            try {
                if(socket == null || socket.isClosed()) {
                    socket = new Socket(SERVER_ADDR, SERVER_PORT);
                    in = new DataInputStream(socket.getInputStream());
                    out = new DataOutputStream(socket.getOutputStream());
                    new Thread(() -> {
                        try{
                           while (true){
                               if (waitAuthorization()) break;
                           }
                           while (true){
                               if (waitDisconnect()) break;
                           }
                        }catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            closeConnection();
                        }
                    }).start();
                }
                out.writeUTF(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    public boolean waitAuthorization() throws IOException {
        String strFromServer = in.readUTF();
        if(strFromServer.startsWith("/authok")) {
            nick = strFromServer.split("\\s+", 2)[1];
            textArea.append("Авторизация успешна \n" + "Welcome " + nick + "\n");
            return true;
        }
        textArea.append(strFromServer + "\n");
        return false;
    }

    public boolean waitDisconnect() throws IOException {
        String strFromServer = in.readUTF();
        if (strFromServer.equalsIgnoreCase("/end")) {
            return true;
        }
        textArea.append(strFromServer + "\n");
        return false;
    }

    public void closeConnection() {
        textArea.append("Соединение с сервером закрыто \n");
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Client();
    }
}
