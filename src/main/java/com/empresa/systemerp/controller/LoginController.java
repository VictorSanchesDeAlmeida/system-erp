package com.empresa.systemerp.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.empresa.systemerp.config.DatabaseConnection;

import com.empresa.systemerp.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginController {

    @FXML
    private Button btnClose;
    @FXML
    private Label responseLabel;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;

    public void btnClose_OnAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void btnSubmit_OnAction(ActionEvent event) {

        if(!txtUsername.getText().trim().isBlank() && !txtPassword.getText().trim().isBlank()){
            responseLabel.setText("trying connection...");
            validateLogin();
        }else{
            responseLabel.setText("Please enter your username and password!");
        }

    }


    public void validateLogin(){

        DatabaseConnection conn = new DatabaseConnection();
        Connection connectDb = conn.getConnection();

        String verifyLogin = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {

            PreparedStatement stmt = connectDb.prepareStatement(verifyLogin);

            stmt.setString(1, txtUsername.getText());
            stmt.setString(2, txtPassword.getText());

            ResultSet queryResult = stmt.executeQuery();

            while (queryResult.next()) {

                if (queryResult.getRow() > 0) {

                    responseLabel.setText("Login successful!!");

                    User user = User.getInstance();
                    user.setUsername(queryResult.getString("username"));
                    user.setFirst_name(queryResult.getString("first_name"));
                    user.setLast_name(queryResult.getString("last_name"));
                    user.setEmail(queryResult.getString("email"));
                    user.setId(queryResult.getInt("id"));

                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/empresa/systemerp/view/ErpScreen.fxml"));
                    Parent root = loader.load();

                    ErpScreen erpScreenController = loader.getController();
                    erpScreenController.setUserName(user.getFullName());

                    Stage newStage = new Stage();
                    newStage.initStyle(StageStyle.DECORATED);
                    newStage.setResizable(false);
                    Scene scene = new Scene(root);
                    newStage.setScene(scene);
                    newStage.show();

                    Stage currentStage = (Stage) responseLabel.getScene().getWindow();
                    currentStage.close();

                }else{
                    responseLabel.setText("Invalidy username ou password...");
                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


}
