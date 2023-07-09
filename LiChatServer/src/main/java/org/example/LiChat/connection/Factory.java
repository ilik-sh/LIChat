package org.example.LiChat.connection;

import org.example.LiChat.Account;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Factory {
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
