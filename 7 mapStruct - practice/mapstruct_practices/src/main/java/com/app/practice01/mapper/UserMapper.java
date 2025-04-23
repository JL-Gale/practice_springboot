package com.app.practice01.mapper;


import com.app.practice01.dto.UserDTO;
import com.app.practice01.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToUserDTO(User user);
    List<UserDTO> userListToUserListDTO(List<User> userList);
}
