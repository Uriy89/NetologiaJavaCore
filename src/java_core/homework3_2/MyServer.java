package java_core.homework3_2;

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

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                requests(out, in);
            }
        }
    }

    private static void requests(PrintWriter out, BufferedReader in) {
        try {
            out.println(String.format("Write your name"));
            final String name;
            name = in.readLine();
            out.println(String.format("Are you child? (yes/no)"));
            final String yesOrNo = in.readLine();
            if (yesOrNo.equals("yes")) out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            else if (yesOrNo.equals("no")) out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
