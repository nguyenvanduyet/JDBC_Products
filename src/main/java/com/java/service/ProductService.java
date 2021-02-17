package com.java.service;

import com.java.model.Products;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductService implements IProductService {
    Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/productManager",
                    "root",
                    "123456"
            );
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException throwables) {
            System.out.println(throwables);
        }
        return connection;
    }

    @Override
    public List<Products> findAll() {
        List<Products> products = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Products product = new Products(id, name, price);
                products.add(product);
            }
        } catch (SQLException throwables) {
            throwables.getMessage();
        }
        return products;
    }
    @Override
    public Products save(int id, Products products) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("insert into product(id,name,price) values (?,?,? )");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, products.getName());
            preparedStatement.setDouble(3,products.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return products;
    }

    @Override
    public Products edit(int id, Products products) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set name= ?, price= ? where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, products.getName());
            preparedStatement.setDouble(3,products.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return products;
    }

    @Override
    public Products findById(int id) {
        Products products = null;
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement =connection.prepareStatement("select * from product where id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                products = new Products(id,name,price);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public void delete(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
