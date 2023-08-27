package com.boots.controller;

import com.boots.entity.User;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/getAllUsers")
    public List<User> userList() {
        return userService.allUsers();
    }

    @PostMapping("/admin/delete")
    public void deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId) {
        if(!userService.deleteUser(userId)) throw new IllegalArgumentException();
    }

    @GetMapping("/admin/getUser")
    public User getUser(@RequestParam(required = true, defaultValue = "") Long userId) {
        return userService.findUserById(userId);
    }
}