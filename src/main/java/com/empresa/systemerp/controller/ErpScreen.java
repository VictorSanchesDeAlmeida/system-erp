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


    public void setUserName(String userName){nameUser.setText("Olá, " + userName);}


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

        AccountController accountController = loader.getController();
        accountController.loadUserInfo();

        contentArea.getChildren().clear();
        contentArea.getChildren().add(fxml);

    }

}
