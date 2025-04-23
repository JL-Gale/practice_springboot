package com.app.practice01.repository;


import com.app.practice01.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    List<User> findAll();
    Optional<User> findById(Long id);
}
