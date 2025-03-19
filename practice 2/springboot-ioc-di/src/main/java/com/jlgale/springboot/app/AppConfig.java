package com.jlgale.springboot.app;

import com.jlgale.springboot.app.repositories.ProductRepository;
import com.jlgale.springboot.app.repositories.ProductRepositoryJson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

@Configuration
@PropertySources(
        @PropertySource("classpath:values.properties")
)
public class AppConfig {

    @Value("classpath:json/product.json")
    Resource resource;

    @Bean("json")
    ProductRepository productRepositoryJson() {
        return new ProductRepositoryJson(resource);
    }
}
