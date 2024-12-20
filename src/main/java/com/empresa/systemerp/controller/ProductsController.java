package com.empresa.systemerp.controller;

import com.empresa.systemerp.model.Products;
import com.empresa.systemerp.model.ProductsModel;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;


public class ProductsController {

    @FXML
    private TableView<Products> tableView;
    @FXML
    private TableColumn<Products, Integer> columnId;
    @FXML
    private TableColumn<Products, String> columnName;
    @FXML
    private TableColumn<Products, String> columnCategory;
    @FXML
    private TableColumn<Products, Double> columnValue;
    @FXML
    private TableColumn<Products, Integer> columnStatus;

    public void initialize(){

        setCell();

        loadData();
    }


    public void setCell(){
        columnId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
        columnName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        columnCategory.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
        columnValue.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getValue()).asObject());
        columnStatus.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStatus()).asObject());
    }


    public void loadData(){

        ProductsModel products = new ProductsModel();
        List<Products> productsList = products.getProducts();

        tableView.getItems().setAll(productsList);

    }



}
