package com.app.services;

import com.app.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();
    User findById(Long id);
}
