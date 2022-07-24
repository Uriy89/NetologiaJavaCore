package java_core.homework3_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        System.out.println("server started");
        int port = 8080;

        try(ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.printf("New connection accepted. Port: %d%n", clientSocket.getPort());
                final String name = in.readLine();
                out.println(String.format("Hi %s, you port is %d", name, clientSocket.getPort()));
            }
        }
    }
}