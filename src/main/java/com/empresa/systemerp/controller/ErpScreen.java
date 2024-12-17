package com.empresa.systemerp.controller;

import com.empresa.systemerp.model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.util.Objects;

public class ErpScreen {

    @FXML
    private StackPane contentArea;
    @FXML
    private Label nameUser;

    private User correntUser;

    public void setUserName(String userName){nameUser.setText("Olá, " + userName);}

    public void setCorrentUser(User user){this.correntUser = user;}

    public void updateUserInfo(String username, String firstName, String lastName, String email) {
        this.correntUser.setUser(username, firstName, lastName, email);
        System.out.println(this.correntUser.getFullName());
    }

    public void DashboardRedirect(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/empresa/systemerp/view/Dashboard.fxml")));
        contentArea.getChildren().clear();
        contentArea.getChildren().add(fxml);

    }

    public void ProductsRedirect(javafx.event.ActionEvent actionEvent) throws IOException {

        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/empresa/systemerp/view/Products.fxml")));
        contentArea.getChildren().clear();
        contentArea.getChildren().add(fxml);

    }

    public void AccoutRedirect(javafx.event.ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/empresa/systemerp/view/Account.fxml"));
        Parent fxml = loader.load();

        AccountController userCorrent = loader.getController();
        userCorrent.loadUserInfo(this.correntUser);
        System.out.println(this.correntUser.getLastName());

        contentArea.getChildren().clear();
        contentArea.getChildren().add(fxml);

    }

}
