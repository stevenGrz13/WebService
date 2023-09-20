package com.example.demo5.solar;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConn() throws Exception{
        String url="postgresql://postgres:4moYomLukPuibaWR7qo9@containers-us-west-204.railway.app:6885/railway";
        String user="postgres";
        String pass="4moYomLukPuibaWR7qo9";
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url,user,pass);
    }
}
