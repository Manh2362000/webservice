package com.example.webservice.repository;

import com.example.webservice.entity.Product;

import java.util.List;

public interface ProductModel {
    Product save(Product obj);

    Product update(Product updateObj, int id);

    boolean delete(int id);

    List<Product> findAll();

    Product findById(int id);
}
