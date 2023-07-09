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
//        SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Account.class)
//                .buildSessionFactory();
//
//        try {
//            Session session = factory.getCurrentSession();
//            Account account = new Account("Leonid", "123");
//            session.beginTransaction();
//            session.save(account);
//            session.getTransaction().commit();
//            session.close();
//        }finally {
//            factory.close();
//        }
    }
}
