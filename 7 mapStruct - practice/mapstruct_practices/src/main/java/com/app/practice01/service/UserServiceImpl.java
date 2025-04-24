package com.app.practice01.service;

import com.app.practice01.dto.UserDTO;
import com.app.practice01.mapper.UserMapper;
import com.app.practice01.repository.IUserRepository;

import java.util.List;


public class UserServiceImpl implements IUserService{

    private IUserRepository userRepository;
    private UserMapper userMapper;

    public UserServiceImpl(IUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDTO> findAll() {
        return userMapper.userListToUserListDTO(userRepository.findAll());
    }

    @Override
    public UserDTO findById(Long id) {
        return userMapper.userToUserDTO(userRepository.findById(id).orElseThrow(NullPointerException::new));
    }
}
