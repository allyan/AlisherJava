package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(10181);
            while (true){
                System.out.println("waiting for client");
                Socket client = serverSocket.accept();
                System.out.println("client connn" + client.getPort());
                new ClientThread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
