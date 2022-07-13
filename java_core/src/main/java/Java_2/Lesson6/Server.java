package Java_2.Lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {


    public static void main(String[]args){

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            new Thread(() -> {
            try {
            while (true) {
                String str = in.readUTF();
                if (str.equals("/end")) {
                    break;
                }
                System.out.println("Клиент написал: " + str);
                out.writeUTF("Клиент пишет: " + str);
            }
            //System.exit(1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            }).start();

            new Thread(() -> {
                try {
                    while (true) {
                        Scanner scanner = new Scanner(System.in);
                        out.writeUTF("Сервер пишет:" + scanner.nextLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
