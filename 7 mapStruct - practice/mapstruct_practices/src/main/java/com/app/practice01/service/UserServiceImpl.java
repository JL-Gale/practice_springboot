package com.app.practice01.service;

import com.app.practice01.model.User;
import com.app.practice01.repository.IUserRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class UserServiceImpl implements IUserService{

    private IUserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NullPointerException::new);
    }
}
