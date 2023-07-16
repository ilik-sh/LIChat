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
    public boolean addUser(@RequestParam(required = true)String username,
                          @RequestParam(required = true)String password,
                          @RequestParam(required = true)String passwordConfirm,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new IllegalArgumentException();
        }
        if (rightArguments(username,password,passwordConfirm)){
            userService.saveUser(new User(username,password,passwordConfirm));
            return true;
        }else return false;
    }

    private boolean rightArguments(String username, String password, String passwordConfirm){
        if(password.equals(passwordConfirm)){
            return userService.findUserByUsername(username) == null;
        }else return false;
    }
}