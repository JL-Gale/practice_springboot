package com.jlgale.springboot.app;

import com.jlgale.springboot.app.models.Item;
import com.jlgale.springboot.app.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("classpath:values.properties")
public class ConfigApp {

    @Bean
    List<Item> listItem() {
        Product product = new Product("Play Station", 1000);
        Product product2 = new Product("Play Station", 1000);
        return Arrays.asList(new Item(product, 2), new Item(product2, 3));
    }

    @Bean
    List<Item> listItem2() {
        Product product = new Product("Play Station 2", 1000);
        Product product2 = new Product("Play Station 2", 1000);
        return Arrays.asList(new Item(product, 2), new Item(product2, 3));
    }
}
