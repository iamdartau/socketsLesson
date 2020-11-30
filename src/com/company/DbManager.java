package com.company;

import java.sql.*;
import java.util.ArrayList;

public class DbManager {

    private static Connection connection;

    public void setConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seusers?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
                SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList <User> getAllFromUsers(){
        ArrayList <User> users = new ArrayList<>();
        try {
            String sql = "select * from seusers";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            while (set.next()){
                int id = set.getInt("id");
                String name = set.getString("name");
                String surname = set.getString("surname");
                users.add(new User(id,name,surname));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

}
