package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class ServerLesson {

    public static void main(String[] args) {
        int id = 0;
        try {
            ServerSocket server = new ServerSocket(3334);
            System.out.println("waiting");
            while (true){
                Socket socket = server.accept();
                id++;
                System.out.println("connected");
                ClientHandler ch = new ClientHandler(socket, id);
                ch.start();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
