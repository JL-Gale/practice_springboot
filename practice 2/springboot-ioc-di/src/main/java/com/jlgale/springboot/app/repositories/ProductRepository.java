package com.jlgale.springboot.app.repositories;

import com.jlgale.springboot.app.models.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
                new Product(1025L, "Array", 3500F),
                new Product(1026L, "Acette", 25500.98F),
                new Product(1027L, "Carne", 19000F),
                new Product(1028L, "Plano", 3500F));
    }

    public List<Product> findAll() {
        return this.data;
    }

    public Product findById(long id) {
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
