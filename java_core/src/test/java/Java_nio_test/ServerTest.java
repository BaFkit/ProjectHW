package Java_nio_test;

import Java_3.Lesson7.Test;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.io.FileInputStream;


public class ServerTest {

    public static final String FILE_PARAMS_TPL = "FILE_NAME=%s&qwerty ";
    public static final String PATH_TO_CLIENT_DIR = "C:\\Users\\Admin\\IdeaProjects\\ProjectHW\\src\\test\\resources\\ClientDir\\";

    @Test
    void sendFileTOServerWithIo() throws IOException {
        Socket clientSocket = new Socket("localhost", 8189);
        File file = new File(PATH_TO_CLIENT_DIR + "file.jpg");
        try (FileInputStream fileInputStream = new FileInputStream(file);
             OutputStream outputStream = clientSocket.getOutputStream()) {
            String metadata = String.format(FILE_PARAMS_TPL, file.getName());
            outputStream.write(metadata.getBytes(StandardCharsets.UTF_8));
//            fileInputStream.transferTo(outputStream);
//            int bytes = fileInputStream.read();
//            outputStream.write(bytes);
        }
    }




}
