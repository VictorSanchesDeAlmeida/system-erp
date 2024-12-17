package com.empresa.systemerp.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection databaseLink;


    public Connection getConnection() {

        String databaseName = "_erp";
        String databaseUser = "root";
        String databasePassword = "almeida2012";
        String databaseUrl = "jdbc:mysql://localhost:3306/" + databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
        }catch(Exception e){
            e.printStackTrace();
        }

        return databaseLink;

    }

}
