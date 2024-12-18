package com.empresa.systemerp.model;

public class User {

    private int id;
    private String username;
    private String first_name;
    private String last_name;
    private String email;

    public User(int id, String username, String first_name, String last_name, String email){

        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;

    }

    public String getFullName(){
        return this.first_name + " " + this.last_name;
    }

    public String getUsername(){
        return  this.username;
    }

    public String getEmail(){
        return  this.email;
    }

    public String getFirstName(){
        return  this.first_name;
    }

    public String getLastName(){
        return  this.last_name;
    }

    public int getId() {
        return  this.id;
    }

    
}
