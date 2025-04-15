package com.app.controllers;

import com.app.dto.UserDTO;
import com.app.domain.models.User;
import com.app.exception.UserNotFoundException;
import com.app.services.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    private IUserService iUserService;

    public AppController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @GetMapping
    public String index1() {
//        var aux = 100/0;
        var aux = Integer.valueOf("10z");
        return "200 ok";
    }

    @GetMapping("/value/{id}")
    public String index2(@PathVariable Integer id) {
        return "200 ok";
    }

    @GetMapping("/value")
    public String index3(@RequestParam Integer id) {
        return "200 ok";
    }

    @GetMapping("/user")
    public List<UserDTO> getFindById() {
        return iUserService.findAll().stream()
                .map(u -> new UserDTO(u.getId(), u.getName(), u.getLastname()))
                .toList();
    }

    @GetMapping("/user/{id}")
    public UserDTO fundById(@PathVariable Long id) {
        //forma 1
//        User user = iUserService.findById(id).orElseThrow(() -> new UserNotFoundException("El usuario no existe"));

        User user = iUserService.findById(id);


//        return new UserDTO(user.getId(), user.getName(), user.getLastname(), new RoleDTO(user.getRole().getName()));


          // Como estamos usando un Opcional no es necesario esta logica
//        if (user == null) {
//            throw new UserNotFoundException("El usuario no existe");
//        }

//        System.out.println(user.getRoleName());
        return new UserDTO(user.getId(), user.getName(), user.getLastname());
//        return user;
    }
}
