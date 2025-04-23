package com.app.practice01.service;

import com.app.practice01.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    User findById(Long id);
}
