package com.lesliefish.web.controller;

import com.lesliefish.web.model.User;
import com.lesliefish.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/getUser")
    public User getUser() {
        User user = userRepository.findByUserName("lesliefish");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

}
