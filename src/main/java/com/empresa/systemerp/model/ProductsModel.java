package com.empresa.systemerp.model;

import com.empresa.systemerp.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductsModel {

    public List<Products> getProducts(){

        List<Products> productsList = new ArrayList<>();

        DatabaseConnection conn = new DatabaseConnection();
        Connection connectionDb = conn.getConnection();

        String query = "SELECT * FROM products";

        try{

            PreparedStatement stmt = connectionDb.prepareStatement(query);
            ResultSet queryResult =  stmt.executeQuery();

            while (queryResult.next()){

                Products products = new Products();
                products.setId(queryResult.getInt("id"));
                products.setName(queryResult.getString("name"));
                products.setCategory(queryResult.getString("category"));
                products.setValue(queryResult.getDouble("value"));
                products.setStatus(queryResult.getInt("status"));

                productsList.add(products);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return productsList;

    }

}
