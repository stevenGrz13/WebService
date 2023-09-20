package com.example.demo5.solar;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConn() throws Exception{
        String url="jdbc:postgresql://localhost:5432/solar";
        String user="postgres";
        String pass="steven";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url,user,pass);
    }
}
