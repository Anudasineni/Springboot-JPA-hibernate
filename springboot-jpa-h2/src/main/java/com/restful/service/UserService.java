package com.restful.service;

import com.restful.Entity.User;
import com.restful.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        User newUser = null;
        Optional<User> optional = userRepository.findById(user.getId());
        if (optional.isPresent()) {
            newUser = optional.get();
            newUser.setName(user.getName());
            newUser.setAddress(user.getAddress());
            userRepository.save(newUser);
        }
        return newUser;
    }

    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "deleted";
    }
}
