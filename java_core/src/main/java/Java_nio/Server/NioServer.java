package Java_nio.Server;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashMap;
import java.util.Map;

public class NioServer {

    private static final Map<SocketChannel, FileChannel> socketFileChannel = new HashMap<>();
    private static final Map<SocketChannel, ConnectionMetadata> socketMetadataMap = new HashMap<>();
    private static final String SERVER_DIR = "C:\\Users\\Admin\\IdeaProjects\\ProjectHW\\src\\main\\resources\\ServerDir\\";

    public NioServer() throws IOException {

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.socket().bind(new InetSocketAddress(8189));
        serverChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("The server started on port 8189. We are waiting for a connection...");

        while (true) {
            selector.select();
            for (SelectionKey event: selector.selectedKeys()) {
                if (event.isValid()) {
                    try {
                      if (event.isAcceptable()) {
                          SocketChannel socketChannel = serverChannel.accept();
                          socketChannel.configureBlocking(false);
                          System.out.println("Подключен " + socketChannel.getRemoteAddress());
                          socketChannel.register(selector, SelectionKey.OP_READ);
                      } else if (event.isReadable()) {
                          SocketChannel socketChannel = (SocketChannel) event.channel();
                          handleReadable(socketChannel);
                      }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            selector.selectedKeys().clear();
        }
    }

    private void handleReadable(SocketChannel socketChannel) throws IOException {
        ConnectionMetadata connectionMetadata = socketMetadataMap.get(socketChannel);
        if (connectionMetadata == null) {
            connectionMetadata = new ConnectionMetadata();
            socketMetadataMap.put(socketChannel, connectionMetadata);
        }
        ByteBuffer inboundBuffer = ByteBuffer.allocate(4096);
        int readBytes;
        FileChannel fileChannel = null;
        while((readBytes = socketChannel.read(inboundBuffer)) > 0) {
            inboundBuffer.flip();
            if(!connectionMetadata.isMetadataLoaded()) {
                loadMetadata(connectionMetadata, inboundBuffer);
            }
            if(inboundBuffer.hasRemaining()) {
                fileChannel = getFileChannel(socketChannel);
                fileChannel.write(inboundBuffer);
                inboundBuffer.clear();
            }

        }
        if (readBytes == -1) {
            if (fileChannel != null) {
                fileChannel.close();
            }
            socketChannel.close();
        }
    }

    private static void loadMetadata(ConnectionMetadata connectionMetadata, ByteBuffer inboundBuffer) {
        while (inboundBuffer.hasRemaining()) { //если в буфере еще есть данные для чтения
            byte nextByte = inboundBuffer.get();
            if (nextByte == ' ') { // метаинформация закончилась, дальше файл
                connectionMetadata.buildMetadata();
                break;
            } else {
                connectionMetadata.getMetadataBuffer().put(nextByte);
            }
        }
    }
    private static FileChannel getFileChannel(SocketChannel socketChannel) throws FileNotFoundException {
        FileChannel fileChannel = socketFileChannel.get(socketChannel);
        ConnectionMetadata connectionMetadata = socketMetadataMap.get(socketChannel);
        if (fileChannel == null) {
            Map<String, String> metadataParams = connectionMetadata.getMetadataParams();
            String fileName = metadataParams.get("FILE_NAME");
            RandomAccessFile fileForSend = new RandomAccessFile(SERVER_DIR + fileName, "rw");
            fileChannel = fileForSend.getChannel();
            socketFileChannel.put(socketChannel, fileChannel);
        }
        return fileChannel;
    }




    public static void main(String[] args) {
        try {
            new NioServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
