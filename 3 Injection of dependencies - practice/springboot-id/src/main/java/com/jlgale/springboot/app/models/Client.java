package com.jlgale.springboot.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
//@SessionScope
//@RequestScope
public class Client {
    @Value("${config.firstname}")
    private String firstname;

    @Value("${config.lastname}")
    private String laststname;
}
