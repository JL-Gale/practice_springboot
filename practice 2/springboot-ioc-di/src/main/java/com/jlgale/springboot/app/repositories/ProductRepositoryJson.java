package com.jlgale.springboot.app.repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jlgale.springboot.app.models.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;


public class ProductRepositoryJson implements ProductRepository{

    List<Product> list;

    public ProductRepositoryJson() {
        Resource resource = new ClassPathResource("json/product.json");
        resources(resource);
    }

    public ProductRepositoryJson(Resource resource) {
        resources(resource);
    }

    private void resources(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        try(InputStream inputStream = resource.getInputStream()) {
            list = Arrays.asList(objectMapper.readValue(inputStream, Product[].class));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public List<Product> findAll() {
        return list;
    }

    @Override
    public Product findById(long id) {
        return list.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
}
