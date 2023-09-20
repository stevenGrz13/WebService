package com.example.demo5.solar.entities;

public class Client {
    int Id;
    String Email;
    String Pass;

    public Client(){}

    public Client(int id, String email, String pass) {
        Id = id;
        Email = email;
        Pass = pass;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }
}
