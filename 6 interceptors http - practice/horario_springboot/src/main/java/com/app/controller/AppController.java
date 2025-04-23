package com.app.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AppController {

    @GetMapping("/test1")
    public ResponseEntity<Map<String, String>> test1(HttpServletRequest request) {
        Map<String, String> bodyJson = new HashMap<>();
        bodyJson.put("title", "Bienvenido");
        bodyJson.put("date", new Date().toString());
        bodyJson.put("message", request.getAttribute("message").toString());
        return ResponseEntity.status(HttpStatus.OK).body(bodyJson);
    }
}
