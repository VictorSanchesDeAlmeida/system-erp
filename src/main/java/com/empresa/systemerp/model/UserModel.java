package com.empresa.systemerp.model;

import com.empresa.systemerp.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserModel extends User {

    public UserModel(int id, String username, String first_name, String last_name, String email) {
        super(id, username, first_name, last_name, email);
    }

    public User saveUserInfo(){
        DatabaseConnection conn = new DatabaseConnection();
        Connection connectionDb = conn.getConnection();

        String updateUser = "UPDATE users SET " +
                            "username = ?, " +
                            "first_name = ?, " +
                            "last_name = ?, " +
                            "email = ? " +
                            "WHERE id = ?";

        try{

            PreparedStatement stmt = connectionDb.prepareStatement(updateUser);

            stmt.setString(1, this.getUsername());
            stmt.setString(2, this.getFirstName());
            stmt.setString(3, this.getLastName());
            stmt.setString(4, this.getEmail());
            stmt.setInt(5, this.getId());

            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected > 0){

                this.setUser(this.getUsername(), this.getFirstName(), this.getLastName(), this.getEmail());

                return this;

            }else {
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
