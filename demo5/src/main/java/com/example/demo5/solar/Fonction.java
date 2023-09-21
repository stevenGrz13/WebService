package com.example.demo5.solar;

import com.example.demo5.solar.entities.Client;
import com.example.demo5.solar.entities.UsefulEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Fonction {

    public static Connexion conn = new Connexion();
    public static ArrayList<Client> getListClient() throws Exception{
        String sql = "select * from client";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Client> clients = new ArrayList<>();
        while(rs.next()){
            Client cl = new Client();
            cl.setId(rs.getInt("id"));
            cl.setEmail(rs.getString("email"));
            cl.setPass(rs.getString("pass"));
            clients.add(cl);
        }
        connection.close();
        return clients;
    }

    public static Client getClientById(int id) throws Exception{
        String sql = "select * from client where id="+id;
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Client cl = new Client();
        while(rs.next()){
            cl.setId(rs.getInt("id"));
            cl.setEmail(rs.getString("email"));
            cl.setPass(rs.getString("pass"));
        }
        connection.close();
        return cl;
    }

    public static UsefulEntity loginClient(String email, String pass) throws Exception{
        UsefulEntity usefulEntitySolar = new UsefulEntity();
        usefulEntitySolar.setState(false);
        ArrayList<Client> liste = getListClient();
        for(int i=0; i<liste.size(); i++){
            if(Objects.equals(email, liste.get(i).getEmail()) && Objects.equals(pass, liste.get(i).getPass())){
                usefulEntitySolar.setIdClient(liste.get(i).getId());
                usefulEntitySolar.setState(true);
            }
        }
        return usefulEntitySolar;
    }

    public static void signUpClient(String email, String pass) throws Exception{
        String sql = "insert into client(email,pass) values ('"+email+"','"+pass+"')";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }

    public static void insertDonnee(String voltage, String courant, String energie, String puissance) throws Exception {
        double[] val = new double[4];
        val[0] = Double.parseDouble(voltage);
        val[1] = Double.parseDouble(courant);
        val[2] = Double.parseDouble(energie);
        val[3] = Double.parseDouble(puissance);
        String sql = "insert into donnees(voltage,courant,energie,puissance) values ("+val[0]+","+val[1]+","+val[2]+","+val[3]+")";
        Connection connection = conn.getConn();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(sql);
        connection.close();
    }
}
