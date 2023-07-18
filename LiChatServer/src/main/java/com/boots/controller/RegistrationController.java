package com.boots.controller;

import com.boots.entity.User;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public void addUser(@RequestParam(required = true)String username,
                          @RequestParam(required = true)String password,
                          @RequestParam(required = true)String passwordConfirm) {
        if (rightArguments(username,password,passwordConfirm)){
            User saveUser = new User();
            saveUser.setUsername(username);
            saveUser.setPassword(password);
            saveUser.setPasswordConfirm(passwordConfirm);
            userService.saveUser(saveUser);
        }else throw new IllegalArgumentException();
    }

    private boolean rightArguments(String username, String password, String passwordConfirm){
        if(password.equals(passwordConfirm)){
            return userService.findUserByUsername(username) == null;
        }else return false;
    }
}