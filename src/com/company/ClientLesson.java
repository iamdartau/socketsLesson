package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ClientLesson {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("name: ");
        String name = scanner.next();
        LocalDateTime dateTime = LocalDateTime.now();
        try {
            Socket socket = new Socket("127.0.0.1", 3334);
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            while (true){
                System.out.println("insert: ");
                String message = scanner.next();
                PackageData packageData = new PackageData(name, message, dateTime);
                output.writeObject(packageData);
                if ((packageData = (PackageData) input.readObject()) !=null){
                    System.out.println(packageData.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
