package com.boots.controller;

import com.boots.entity.User;
import com.boots.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin/getAllUsers")
    public JSONObject userList() {
        List<User> users = userService.allUsers();
        JSONObject returnJSON = new JSONObject();
        returnJSON.put("Users",users);
        return returnJSON;
    }

    @PostMapping("/admin/delete")
    public boolean deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId) {
        if(isUserPresent(userId)) return userService.deleteUser(userId);
        else throw new IllegalArgumentException();
    }

    @GetMapping("/admin/getUser")
    public JSONObject getUser(@RequestParam(required = true, defaultValue = "") Long userId) {
        JSONObject returnJSON = new JSONObject();
        User returnUser = userService.findUserById(userId);
        returnJSON.put("username",returnUser.getUsername());
        returnJSON.put("password",returnUser.getPassword());
        returnJSON.put("Roles",returnUser.getRoles());
        return returnJSON;
    }

    private boolean isUserPresent(Long userId){
        return userService.findUserById(userId)!=null;
    }
}