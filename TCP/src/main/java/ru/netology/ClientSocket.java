package ru.netology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSocket {

    public static void main(String[] args) {

        try (Socket serverSocket = new Socket(ServerConfig.HOST, ServerConfig.port)) {
            PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(serverSocket.getInputStream())); {

                Scanner scanner = new Scanner(System.in);
                System.out.println(in.readLine());

                out.println(scanner.nextLine());

            }

    } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    }

