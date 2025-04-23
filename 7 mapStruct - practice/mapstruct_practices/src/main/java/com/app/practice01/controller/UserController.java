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
    private UserMapper userMapper;

    @GetMapping("/findAll")
    public List<UserDTO> findAll() {
//        return userService.findAll().stream()
//                .map(user -> new UserDTO(user.getId(), user.getName(), user.getLastname(), user.getAge(), user.getSalary(), user.getStatus(), user.getTime()))
//                .toList();
        return userMapper.userListToUserListDTO(userService.findAll());
    }

    @GetMapping("/findById")
    public UserDTO findById(@RequestParam Long id) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setId(userService.findById(id).getId());
//        userDTO.setName(userService.findById(id).getName());
//        userDTO.setLastname(userService.findById(id).getLastname());
//        userDTO.setAge(userService.findById(id).getAge());
//        userDTO.setSalary(userService.findById(id).getSalary());
//        userDTO.setStatus(userService.findById(id).getStatus());
//        userDTO.setTime(userService.findById(id).getTime());
//        return userDTO;
        return userMapper.userToUserDTO(userService.findById(id));
    }


}
