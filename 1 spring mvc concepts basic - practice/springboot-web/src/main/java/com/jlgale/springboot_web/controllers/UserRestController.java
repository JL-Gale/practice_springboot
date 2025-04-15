package com.jlgale.springboot_web.controllers;

import com.jlgale.springboot_web.models.User;
import com.jlgale.springboot_web.models.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object> detailsModel() {
        Map<String, Object> body = new HashMap<>();
        body.put("h1", "Primer hola mundo con spring");
        body.put("title", "SpringBoot");
        body.put("firstname", "JL");
        body.put("lastname", "Gale");
        body.put("name1", "mariana");
        body.put("name2", "cecilia");
        body.put("name3", "milton");
        return body;
    }

    @GetMapping("/usermap")
    public Map<String, Object> detailsUser() {
        User user = new User("JL", "Gale");
        Map<String, Object> body = new HashMap<>();
        body.put("Title", "Hola mundo desde una api rest");
        body.put("User", user);
        return body;
    }

    @GetMapping("/user")
    public User detailsUser2() {
        User user = new User("JL", "Gale");
        return user;
    }

    @GetMapping("/userdto")
    public UserDto detailsUser3() {
        User user = new User("JL", "Gale");
        UserDto userDto = new UserDto();
        userDto.setTitle("Hola mundo desde un Dto");
        userDto.setUser(user);
        return userDto;
    }

    @GetMapping("/userlist")
    public List<User> detailsUser4() {
        User user = new User("JL", "Gale");
        User user2 = new User("Milton", "Cersar");
        User user3 = new User("Cecilia", "Montiel");
        User user4 = new User("Jorge", "mejia");
//        User[] userArray =  {user, user2, user3, user4};
//        Map<String,Object> body = new HashMap<>();
//        body.put("list", userArray);

        List<User> body = Arrays.asList(user, user2, user3, user4);

//        body.add(user);
//        body.add(user2);
//        body.add(user3);
//        body.add(user4);
        return body;
    }

}
