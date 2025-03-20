package com.jlgale.springboot.app.controllers;

import com.jlgale.springboot.app.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Test {

    @Autowired
    private Invoice invoice;

    @GetMapping
    public Invoice test1() {
        return invoice;
    }
}
