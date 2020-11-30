package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DbManager manager = new DbManager();
        manager.setConnection();
        for (User u : manager.getAllFromUsers()
        ) {
            System.out.println(u);
        }

    }


}
