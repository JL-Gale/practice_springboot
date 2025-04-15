package com.app.services;

import com.app.domain.models.User;
import com.app.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    List<User> userList;

    public UserServiceImpl(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public User findById(Long id) {
//        User user = null;
//        for (User u : userList) {
//            if (u.getId().equals(id)) {
//                user = u;
//                break;
//            }
//        }

//        if (user == null) {
//            return Optional.empty();
//        }

//        return Optional.ofNullable(user);

        return userList.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new UserNotFoundException("El usuario no existe"));

//        return userList.stream()
//                .filter(u -> u.getId().equals(id))
//                .findFirst();
    }
}
