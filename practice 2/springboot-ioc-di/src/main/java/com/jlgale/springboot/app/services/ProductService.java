package com.jlgale.springboot.app.services;

import com.jlgale.springboot.app.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(long id);
}
