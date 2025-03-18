package com.jlgale.springboot.app.models;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product implements Cloneable{

    private Long id;
    private String name;
    private Float price;

    @Override
    public Object clone()  {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Product(id, name, price);
        }
    }
}
