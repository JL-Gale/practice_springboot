package com.app.practice01.repository;

import com.app.practice01.model.User;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements IUserRepository{

    private List<User> userList;

    public UserRepositoryImpl() {
        this.userList = Arrays.asList(new User(1L, "JL-Gale", "Doe", 21, 250F, false, LocalDateTime.now()),
                new User(2L, "JL-Gale", "Doe2", 21, 250F, false, LocalDateTime.now()),
                new User(3L, "JL-Gale", "Doe3", 21, 250F, false, LocalDateTime.now()),
                new User(4L, "JL-Gale", "Doe4", 21, 250F, false, LocalDateTime.now()));
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
}
