package com.app;

import com.app.domain.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<User> listUser() {
        return Arrays.asList(
                new User(1L, "JL-Gale", "Doe"),
                new User(2L, "Cecilia", "Doe"),
                new User(3L, "Mariana", "Doe"));
    }
}
