package org.example.socket;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    static void main() {

        int port = 3000;

        try (ServerSocket serverSocket = new ServerSocket(port, 64)) {
            System.out.println("Starting server at port: " + serverSocket.getLocalPort());

            while (true) {
                Socket socket = serverSocket.accept();
                Thread.ofVirtual().start(() -> handleClient(socket));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void handleClient(Socket socket) {
        try (Socket client = socket) {
            System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream, true);

            System.out.println("Message from client: " + reader.readLine());

            writer.println("Hello There from Server");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}