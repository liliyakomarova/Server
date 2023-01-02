package org.example;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private static final int PORT = 8080;
    private static final String HOST = null;

    public static void main(String[] args) throws IOException {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            String smth = in.readLine();
            System.out.println(smth);
            if (!smth.equals("???")) {
                System.out.println("Введите название города с последней буквы");
                Scanner scanner = new Scanner(System.in);
                String newTown = scanner.nextLine();
                out.println(newTown);
                System.out.println(in.readLine());
                in.close();
                out.close();
                clientSocket.close();
            } else {
                System.out.println("Введите название города");
                Scanner scanner = new Scanner(System.in);
                String inp = scanner.nextLine();
                out.println(inp);
                in.close();
                out.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}