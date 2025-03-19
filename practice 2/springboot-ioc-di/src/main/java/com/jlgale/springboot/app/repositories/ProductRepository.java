package com.jlgale.springboot.app.repositories;

import com.jlgale.springboot.app.models.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(long id);
}
