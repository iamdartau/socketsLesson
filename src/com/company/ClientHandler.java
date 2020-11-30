package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;

public class ClientHandler extends Thread {

    private Socket socket;
    private int id;

    public ClientHandler(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    @Override
    public void run() {
        try {

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            PackageData data = null;
            LocalDateTime dateTime = LocalDateTime.now();
            while ((data = (PackageData) input.readObject())!=null){
                System.out.println(id + ": " + data);
                PackageData response = null;
                if (data.getMessage().equalsIgnoreCase("hello")){
                    response = new PackageData("Server", "Hello!", dateTime);
                }else if (data.getMessage().toLowerCase().equals("lol")){
                    response = new PackageData("Server", "Lol", dateTime);
                }
                output.writeObject(response);
            }

        }catch (Exception e){

        }
    }
}
