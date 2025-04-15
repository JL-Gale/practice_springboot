package com.jlgale.springboot.app.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jlgale.springboot.app.models.Client;
import com.jlgale.springboot.app.models.Invoice;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    @JsonIgnore
    private Invoice invoice;

    @GetMapping
    public Invoice show() {
        Invoice auxInvoice = (Invoice) invoice.clone();
        // estos metodos estan por que se dibia pasar solo los valores necesarios al
        // jackson, se debe mostrar un dto pero me dio flojera y use la misma clase kkkkkkk
        
//        auxInvoice.setClient(new Client(invoice.getClient().getFirstname(), invoice.getClient().getLaststname()));
//        auxInvoice.setDescription(invoice.getDescription());
//        auxInvoice.setListItems(invoice.getListItems());
        System.out.println(AopUtils.isAopProxy(invoice));
        return auxInvoice;
    }
}
