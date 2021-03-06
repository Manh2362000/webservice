package com.example.webservice.repository;


import com.example.webservice.entity.Product;
import com.example.webservice.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlProductModel implements ProductModel {

    @Override
    public Product save(Product obj){
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "insert into products" +
                    "(name,price)" +
                    "values" +
                    "(? ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,obj.getName());
            preparedStatement.setDouble(2,obj.getPrice());
            preparedStatement.execute();
            System.out.println("Acction success!");
            return obj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public  Product update(Product updateObj, int id)   {
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "update products"+
                    "set name = ?,price = ? where id =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, updateObj.getName());
            preparedStatement.setDouble(2, updateObj.getPrice());
            preparedStatement.setInt(3,id);
            preparedStatement.execute();
            System.out.println("Action success!");
            return updateObj;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(int id){
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery ="delete from products"+
                    "where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            System.out.println("Action success!");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> findAll(){
        List<Product> list = new ArrayList<>();
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * form products";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                Product obj = new Product();
                obj.setId(id);
                obj.setName(name);
                obj.setPrice(price);
                list.add(obj);
            }
            System.out.println("Action success!");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    @Override
    public Product findById(int id){
        Product obj = null;
        try{
            Connection connection = ConnectionHelper.getConnection();
            String sqlQuery = "select * form products where id = ?  ";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){

                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                 obj = new Product();
                obj.setId(id);
                obj.setName(name);
                obj.setPrice(price);
            }
            System.out.println("Action success!");


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return obj;
    }

}
