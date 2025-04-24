package com.app.practice01.service;

import com.app.practice01.dto.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> findAll();
    UserDTO findById(Long id);
}
