package com.jlgale.springboot_web.controllers;

import com.jlgale.springboot_web.models.User;
import com.jlgale.springboot_web.models.dto.ParamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/var")
public class PathVariableController {

    @Value("${config.firstname}")
    private String firstname;

    @Value("${config.lastname}")
    private String lastname;

    @Value("${config.aux}")
    private Boolean aux;

//    @Value("${config.age}")
//    private Integer age;

    @Value("${config.message}")
    private String message;

    @Value("${config.list}")
    private List<String> nombres;

    @Value("#{'${config.list}'.split(',')}")
    private List<String> nombres2;

    @Value("#{'${config.list}'.toUpperCase()}")
    private String nombres3;

    @Value("${config.test}")
    private String test;

    @Value("#{${config.map}}")
    private Map<String, Object> mapBody;

    @Value("#{${config.map}.aux}")
    private Boolean mapAux;

    @Autowired
    private Environment environment;

    @GetMapping("/foo/{message}/{age}/{aux}/{firstname}/{lastname}")
    public ParamDto foo(
            @PathVariable(name = "message") String messageOtro,
            @PathVariable Integer age,
            @PathVariable Boolean aux,
            @PathVariable String firstname,
            @PathVariable String lastname) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(messageOtro);
        paramDto.setAge(age);
        paramDto.setAux(aux);
        paramDto.setFirstname(firstname);
        paramDto.setLasstname(lastname);
        return paramDto;
    }

    @GetMapping("/foo2/{message}/{age}/{aux}/{firstname}/{lastname}")
    public Map<String, Object> foo2(
            @PathVariable(name = "message") String messageOtro,
            @PathVariable Integer age,
            @PathVariable Boolean aux,
            @PathVariable String firstname,
            @PathVariable String lastname) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", messageOtro);
        body.put("age", age);
        body.put("firstname", firstname);
        body.put("lastname", lastname);
        body.put("aux", aux);
        return body;
    }

    @PostMapping("/create")
    public User foo3(@RequestBody User user){
        user.setFirstname(user.getFirstname().toLowerCase());
        return user;
    }

    @GetMapping("/value")
    public Map<String, Object> foo4(@Value("${config.age}") Integer age) {
        Map<String, Object> body = new HashMap<>();
        body.put("firstname", firstname);
        body.put("lastname", lastname);
        body.put("message", message);
        body.put("age", age);
        body.put("aux", aux);
        body.put("list", nombres);
        body.put("list2", nombres2);
        body.put("list3", nombres3);
        body.put("prueba", test);
        body.put("map", mapBody);
        return body;
    }

    @GetMapping("/value2")
    public Map<String, Object> foo5() {
        return mapBody;
    }

    @GetMapping("/value3")
    public Map<String, Object> foo6() {
        Map<String, Object> body = new HashMap<>();
        body.put("aux", mapAux);
        return body;
    }

    @GetMapping("/value4")
    public Map<String, Object> foo7() {
        Map<String, Object> body = new HashMap<>();
        body.put("firstname", environment.getProperty("config.firstname"));
        body.put("lastname", environment.getProperty("config.lastname"));
        body.put("message", environment.getProperty("config.message"));
        body.put("aux", Boolean.parseBoolean(environment.getProperty("config.aux")));
        body.put("list", environment.getProperty("config.list"));
        body.put("list2", nombres2);
        body.put("list3", nombres3);
        body.put("prueba", environment.getProperty("config.test"));
//        body.put("age", Integer.valueOf(environment.getProperty("config.age")));
        body.put("age", environment.getProperty("config.age", Integer.class));
        body.put("map", mapBody);
        return body;
    }
}
