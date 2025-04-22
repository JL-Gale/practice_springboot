package com.app.interceptors.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
//@Controller
@RequestMapping("/api")
public class AppController {

    @GetMapping("/test1")
    public Map<String, Object> test1() {
        return Collections.singletonMap("message", "handler test1 del controlador");
    }

    @GetMapping("/test2")
    public Map<String, Object> test2() {
        return Collections.singletonMap("message", "handler test2 del controlador");
    }

    @GetMapping("/test3")
    public Map<String, Object> test3() {
        return Collections.singletonMap("message", "handler test3 del controlador");
    }

    @GetMapping("/test4")
    public Map<String, Object> test4() {
        return Collections.singletonMap("message", "handler test4 del controlador");
    }

      // para cuando solo se use @Controller
//    @GetMapping("/test")
//    public ResponseEntity<String> test() {
//        return ResponseEntity.ok("Todo bien");
//    }
}
