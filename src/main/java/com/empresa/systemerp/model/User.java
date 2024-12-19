package com.empresa.systemerp.model;

public class User {

    private static User instanciaUnica;

    private int id;
    private String username;
    private String first_name;
    private String last_name;
    private String email;


    public static User getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new User();
        }
        return instanciaUnica;
    }

    public User(){}

    public String getFullName(){
        return this.first_name + " " + this.last_name;
    }

    public String getUsername(){
        return  this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getEmail(){
        return  this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getFirstName(){
        return  this.first_name;
    }
    public void setFirst_name(String first_name){
        this.first_name = first_name;
    }

    public String getLastName(){
        return  this.last_name;
    }
    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public int getId() {
        return  this.id;
    }
    public void setId(int id){
        this.id = id;
    }

    
}
