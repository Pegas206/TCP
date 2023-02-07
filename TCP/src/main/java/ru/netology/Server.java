package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

import static ru.netology.ServerConfig.*;

public class Server {


    public static void main(String[] args) {


        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен");


            // ждем подключения
            try (Socket clientSocket = serverSocket.accept()) {
                try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                        // ваш код
                        System.out.println("New connection accepted " + clientSocket.getPort());

                        Scanner scanner = new Scanner(System.in);
                        out.println(scanner.nextLine());

                        final String name = in.readLine();

                        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
