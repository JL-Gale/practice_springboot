package com.jlgale.springboot.app.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Client {
    @Value("${config.firstname}")
    private String firstname;

    @Value("${config.lastname}")
    private String laststname;
}
