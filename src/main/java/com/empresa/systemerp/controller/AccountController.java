package com.empresa.systemerp.controller;

import com.empresa.systemerp.model.User;
import com.empresa.systemerp.model.UserModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
            User saving = saveUser.updateUserInfo(username.getText(), firstName.getText(), lastName.getText(), email.getText());

            if (saving != null){
                statusMessage.setText("Informações salvas com sucesso!!");
            }else {
                statusMessage.setText("Algo deu errado, contate o suporte.");
            }

        }else{
            statusMessage.setText("Some fields are empty");
        }

    }


}
