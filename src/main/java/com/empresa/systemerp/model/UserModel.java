package com.empresa.systemerp.model;

import com.empresa.systemerp.config.DatabaseConnection;
import com.empresa.systemerp.controller.ErpScreen;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserModel extends User {

    public UserModel(int id, String username, String first_name, String last_name, String email) {
        super(id, username, first_name, last_name, email);
    }

    public User updateUserInfo(String username, String firstname, String lastname, String email){
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

            stmt.setString(1, username);
            stmt.setString(2, firstname);
            stmt.setString(3, lastname);
            stmt.setString(4, email);
            stmt.setInt(5, this.getId());

            int rowsAffected = stmt.executeUpdate();

            if(rowsAffected > 0){

                User user = new User(this.getId(), username, firstname, lastname, email);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/empresa/systemerp/view/ErpScreen.fxml"));
                Parent root = loader.load();

                ErpScreen erpScreenController = loader.getController();
                erpScreenController.setCorrentUser(user);

                System.out.println(user.getFullName());
                return user;

            }else {
                System.out.println("Usuario Não atualizado...");
                return null;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
