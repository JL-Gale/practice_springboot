package com.jlgale.springboot.app.services;

import com.jlgale.springboot.app.models.Product;
import com.jlgale.springboot.app.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    ProductRepository productRepository = new ProductRepository();

    public List<Product> findAll() {
        return productRepository.findAll().stream().map(p -> {
            Product pro = (Product) p.clone();
            pro.setPrice((float) Math.round(p.getPrice() + (float) (p.getPrice() * 0.19)));
            return pro;
        }).collect(Collectors.toList());
    }
    public Product findById(Long id) { return productRepository.findById(id); }
}
