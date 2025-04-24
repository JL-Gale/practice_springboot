package com.app.practice01.controller;

import com.app.practice01.dto.UserDTO;
import com.app.practice01.mapper.UserMapper;
import com.app.practice01.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    private IUserService userService;

    @GetMapping("/findall")
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findbyid")
    public UserDTO findById(@RequestParam Long id) {
        return userService.findById(id);
    }


}
