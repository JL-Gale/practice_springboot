package com.jlgale.springboot.app.services;

import com.jlgale.springboot.app.models.Product;
import com.jlgale.springboot.app.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

//    @Autowired
//    @Qualifier("productList")
    ProductRepository productRepository;
//    @Value("${config.tax}")
//    private float tax;
    Environment tax;


    public ProductServiceImpl(@Qualifier("json") ProductRepository productRepository, Environment tax) {
        this.productRepository = productRepository;
        this.tax = tax;
    }

//    @Autowired
//    @Qualifier("productList")
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll().stream().map(p -> {
            Product pro = (Product) p.clone();
//            Product pro = new Product(p.getId(), p.getName(), p.getPrice());
            pro.setPrice((float) Math.round(p.getPrice() + (float) (p.getPrice() * tax.getProperty("config.tax", Float.class))));
            return pro;
        }).collect(Collectors.toList());
    }

    public Product findById(long id) { return productRepository.findById(id); }
}
