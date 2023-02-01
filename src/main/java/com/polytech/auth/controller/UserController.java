package com.polytech.auth.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import com.polytech.auth.mapper.UserMapper;
import com.polytech.auth.model.User;
import com.polytech.auth.dto.UserDTO;
import com.polytech.auth.service.UserService;

import java.util.*;

@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<User> users = userService.getAllUsers();
        List<UserDTO> usersDtos = UserMapper.toUserDTOList(users);

        return ResponseEntity.ok(usersDtos);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer userId) {

        User user = userService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.notFound().build();
        } 
        UserDTO dto = UserMapper.toUserDTO(user);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO dto) {
        User fromDto = UserMapper.toUser(dto);
        User createdUser = userService.createUser(fromDto);
        if (createdUser == null) {
            return ResponseEntity.badRequest().build();
        }
        UserDTO createdUserDto = UserMapper.toUserDTO(createdUser);
        return ResponseEntity.ok(createdUserDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable Integer userId) {
        User foundUser = userService.getUserById(userId);
        if (foundUser == null) {
            return ResponseEntity.notFound().build();
        }
        boolean result = userService.deleteUser(userId);
        
        if (!result) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}