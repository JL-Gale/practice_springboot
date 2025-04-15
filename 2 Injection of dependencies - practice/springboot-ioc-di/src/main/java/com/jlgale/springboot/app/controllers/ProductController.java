package com.jlgale.springboot.app.controllers;

import com.jlgale.springboot.app.models.Product;
import com.jlgale.springboot.app.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {


    ProductService productService;

//    @Autowired
//    public void setProductService(ProductService productService) {
//        this.productService = productService;
//    }

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/findall")
    public List<Product> finAll() {
        return productService.findAll();
    }

    @GetMapping("/findbyid")
    public Product findByid(@RequestParam(required = false) Long id) {
        Product aux = productService.findById(id);
        return productService.findById(id);
    }
}
