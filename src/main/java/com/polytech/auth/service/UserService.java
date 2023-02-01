package com.polytech.auth.service;

import org.springframework.stereotype.Service;
import com.polytech.auth.model.User;
import com.polytech.auth.repository.UserRepository;
import java.util.*;


@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
        this.initUsers();
    }

    public void initUsers() {
        User user1 = new User();
        user1.setName("user1");
        user1.setEmail("mail@test.com");

        User user2 = new User();
        user2.setName("user2");
        user2.setEmail("mail2@test.com");

        this.repository.save(user1);
        this.repository.save(user2);
    }

    public List<User> getAllUsers() {
        return this.repository.findAll();
    }

    public User getUserById(Integer id) {

        Optional<User> found = this.repository.findById(id);

        if (found.isPresent()) {
            return found.get();
        }
        return null;
    }

    public User createUser(User givenUser) {

        if (givenUser.getName() != null && givenUser.getEmail() != null) {
            this.repository.save(givenUser);
        }
        return null;
    }

    public boolean deleteUser(Integer userId) {
        User found = getUserById(userId);
        if (found != null) {
            this.repository.deleteById(found.getId());
            return true;
        }
        return false;
    }
}
