package java_core.homework3_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 8080;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String resp = in.readLine();
            System.out.println(resp);

            Scanner sc = new Scanner(System.in);
            String name = sc.next();
            out.println(name);


            String yon = in.readLine();
            System.out.println(yon);

            String req = sc.next();
            out.println(req);

            String res = in.readLine();
            System.out.println(res);
        }
    }

}
