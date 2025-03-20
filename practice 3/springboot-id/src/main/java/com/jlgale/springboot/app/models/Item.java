package com.jlgale.springboot.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private Product product;
    private Integer quantity;

    public Integer getTotal() {
        return product.getPrice() * this.quantity;
    }

}
