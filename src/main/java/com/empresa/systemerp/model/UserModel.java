package com.empresa.systemerp.model;

import com.empresa.systemerp.config.DatabaseConnection;
import com.empresa.systemerp.controller.ErpScreen;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserModel {

    public Boolean updateUserInfo(String username, String firstname, String lastname, String email){
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

            User user = User.getInstance();

            stmt.setString(1, username);
            stmt.setString(2, firstname);
            stmt.setString(3, lastname);
            stmt.setString(4, email);
            stmt.setInt(5, user.getId());

            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected > 0){

                user.setUsername(username);
                user.setFirst_name(firstname);
                user.setLast_name(lastname);
                user.setEmail(email);

                return true;

            }else {
                System.out.println("Usuario Não atualizado...");
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
