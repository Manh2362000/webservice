package com.example.webservice.resource;

import com.example.webservice.entity.Product;
import com.example.webservice.repository.ProductModel;

import javax.ws.rs.*;
import java.util.List;

@Path("/products")
@Produces("application/json")
@Consumes("application/json")
public class ProductResource {
    private final ProductModel productModel;

    public ProductResource() {
        productModel = new ProductModel() {
            @Override
            public Product save(Product obj) {
                return null;
            }

            @Override
            public Product update(Product updateObj, int id) {
                return null;
            }

            @Override
            public boolean delete(int id) {
                return false;
            }

            @Override
            public List<Product> findAll() {
                return null;
            }

            @Override
            public Product findById(int id) {
                return null;
            }
        };
    }

}