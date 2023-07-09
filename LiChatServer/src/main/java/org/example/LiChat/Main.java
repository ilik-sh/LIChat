package org.example.LiChat;

import org.example.LiChat.connection.Factory;
import org.example.LiChat.service.AuthorizationService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AuthorizationService authorizationService = new AuthorizationService();
        System.out.println(authorizationService.signIn(new Account("Ilya","123")));
    }
}
