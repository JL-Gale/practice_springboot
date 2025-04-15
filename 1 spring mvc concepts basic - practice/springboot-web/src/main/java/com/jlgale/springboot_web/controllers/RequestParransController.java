package com.jlgale.springboot_web.controllers;

import com.jlgale.springboot_web.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/params")
public class RequestParransController {

    @GetMapping("/foo")
    public Map<String, Object> reques1(@RequestParam String message) {
        Map<String, Object> body = new HashMap<>();
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        body.put("Objeto", paramDto);
        return body;
    }

    @GetMapping("/foo2")
    public ParamDto reques2(@RequestParam(required = false, defaultValue = "Not Found") String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/foo3")
    public Map<String, Object> reques3(
            @RequestParam(required = false, defaultValue = "Not Found") String firstname,
            @RequestParam(required = false, defaultValue = "Not Found") String lastname,
            @RequestParam(required = false, defaultValue = "Not Found") Integer age) {
        Map<String, Object> body = new HashMap<>();
        body.put("Firstname", firstname);
        body.put("Laststname", lastname);
        body.put("Age", age != null ? age : "Not Found");
        return body;
    }

    @GetMapping("/foo4")
    public ParamDto foo4(
            @RequestParam(required = false, defaultValue = "Not Found") String message,
            @RequestParam(required = false) boolean aux,
            @RequestParam(required = false, defaultValue = "Not Found") String firstname,
            @RequestParam(required = false, defaultValue = "Not Found") String lastname,
            @RequestParam(required = false) Integer age){
        return new ParamDto(message, age, firstname, lastname, aux);
    }

    @GetMapping("/foo5")
    public ParamDto foo5(HttpServletRequest request) {
        ParamDto paramDto = new ParamDto();
        int number = 0;
        try {
            number = Integer.parseInt(request.getParameter("age"));
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }
        paramDto.setMessage(request.getParameter("message") != null ? request.getParameter("message") : "Not Found");
        paramDto.setAge(number != 0 ? number : null);
        paramDto.setFirstname(request.getParameter("firstname"));
        paramDto.setLasstname(request.getParameter("lastname"));
        paramDto.setAux(Boolean.parseBoolean(request.getParameter("aux")));
        return paramDto;
    }
}
