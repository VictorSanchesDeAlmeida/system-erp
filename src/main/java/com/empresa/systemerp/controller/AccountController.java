package com.empresa.systemerp.controller;

import com.empresa.systemerp.model.User;
import com.empresa.systemerp.model.UserModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;


public class AccountController {

    @FXML
    private Label statusMessage;
    @FXML
    private TextField username;
    @FXML
    private  TextField email;
    @FXML
    private  TextField firstName;
    @FXML
    private  TextField lastName;

    private int userId;

    public void loadUserInfo(User correntUser){

        this.userId = correntUser.getId();

        username.setText(correntUser.getUsername());
        email.setText(correntUser.getEmail());
        firstName.setText(correntUser.getFirstName());
        lastName.setText(correntUser.getLastName());
    }

    public void SaveUser(){

        statusMessage.setText("Trying to save...");

        if(!username.getText().isBlank() && !email.getText().isBlank() && !firstName.getText().isBlank() && !lastName.getText().isBlank()){
            statusMessage.setText("Saving...");

            UserModel saveUser = new UserModel(this.userId, username.getText(), firstName.getText(), lastName.getText(), email.getText());
            User saving = saveUser.saveUserInfo();

            if (saving != null){
                statusMessage.setText("Informações salvas com sucesso!!");

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/empresa/systemerp/view/ErpScreen.fxml"));
                    Parent root = loader.load();
                    ErpScreen chageName = loader.getController();
                    chageName.setCorrentUser(saving);
                    chageName.updateUserInfo(saving.getUsername(), saving.getFirstName(), saving.getLastName(), saving.getEmail());
                    chageName.setUserName(saving.getFirstName() + " " + saving.getLastName());
                } catch (IOException e) {
                    statusMessage.setText("Error loading screen: " + e.getMessage());
                }

            }else {
                statusMessage.setText("Algo deu errado, contate o suporte.");
            }

        }else{
            statusMessage.setText("Some fields are empty");
        }

    }


}
