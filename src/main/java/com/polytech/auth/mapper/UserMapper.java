package com.polytech.auth.mapper;

import com.polytech.auth.dto.UserDTO;
import com.polytech.auth.model.User;

import java.util.*;

public class UserMapper {

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                        .name(user.getName())
                        .email(user.getEmail())
                        .build();
    }

    public static List<UserDTO> toUserDTOList(List<User> list) {
        List<UserDTO> dtoList = new ArrayList<>();
        for (User user : list) {
            dtoList.add(toUserDTO(user));
        }
        return dtoList;
    }
    
    public static User toUser(UserDTO dto) {
        return User.builder()
                        .name(dto.getName())
                        .email(dto.getEmail())
                        .build();
    }

    public static List<User> toUserList(List<UserDTO> list) {
        List<User> userList = new ArrayList<>();
        for (UserDTO dto : list) {
            userList.add(toUser(dto));
        }
        return userList;
    }
    
}
