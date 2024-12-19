package com.empresa.systemerp.controller;

import com.empresa.systemerp.model.User;
import com.empresa.systemerp.model.UserModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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


    public void loadUserInfo(){

        User user = User.getInstance();

        username.setText(user.getUsername());
        email.setText(user.getEmail());
        firstName.setText(user.getFirstName());
        lastName.setText(user.getLastName());
    }

    public void SaveUser(ActionEvent event) throws IOException {

        statusMessage.setText("Trying to save...");

        if(!username.getText().isBlank() && !email.getText().isBlank() && !firstName.getText().isBlank() && !lastName.getText().isBlank()){
            statusMessage.setText("Saving...");

            UserModel saveUser = new UserModel();
            Boolean isSaved = saveUser.updateUserInfo(username.getText(), firstName.getText(), lastName.getText(), email.getText());

            if(isSaved){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/empresa/systemerp/view/ErpScreen.fxml"));
                Parent root = loader.load();

                ErpScreen erpScreen = loader.getController();

                erpScreen.setUserName(User.getInstance().getFullName());
                erpScreen.AccoutRedirect(null);

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                stage.setScene(new Scene(root));
                stage.show();

                statusMessage.setText("Informações salvas com sucesso!!");

            }else{
                statusMessage.setText("Algo deu errado...");
            }

        }else{
            statusMessage.setText("Some fields are empty");
        }

    }


}
