
package com.greetings;

import com.utils.Utils;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    public static void runServer() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server waiting for client...");
            try (Socket client = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                 BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

                System.out.println("Client connected!");

                Thread readThread = new Thread(() -> {
                    try {
                        String line;
                        while ((line = in.readLine()) != null) {
                            System.out.println("Client: " + line);
                        }
                    } catch (IOException e) {
                        System.out.println("Connection closed.");
                    }
                });
                readThread.start();

                String input;
                while ((input = userInput.readLine()) != null) {
                    out.println(input);
                }
            }
        }
    }

    public static void runClient() throws IOException {
        try (Socket socket = new Socket("localhost", 12345);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in))) {

            Thread readThread = new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        System.out.println("Server: " + line);
                    }
                } catch (IOException e) {
                    System.out.println("Connection closed.");
                }
            });
            readThread.start();

            String input;
            while ((input = userInput.readLine()) != null) {
                out.println(input);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Utils.getWelcomeMessage("Monika"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Run as (server/client): ");
        String role = scanner.nextLine().trim().toLowerCase();

        if ("server".equals(role)) {
            runServer();
        } else if ("client".equals(role)) {
            runClient();
        } else {
            System.out.println("Invalid role. Use 'server' or 'client'.");
        }
    }
}
