package org.example.LiChat.service;

import org.example.LiChat.Account;
import org.example.LiChat.connection.Factory;
import org.hibernate.Session;

import java.util.List;


public class AuthorizationService {

    public boolean signIn(Account account){
        List accounts = findAccount(account.getLogin());
        if(accounts.size()==0){
            return false;
        }else {
            Account checkAccount = (Account) accounts.get(0);
            return checkAccount.getPassword().equals(account.getPassword());
        }
    }

    public boolean saveAccount(Account account){
        Session session = Factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List accounts = session.createQuery("from Account "+
                "where login='"+account.getLogin()+"'").getResultList();
        if(accounts.size() == 0){
            session.save(account);
            session.getTransaction().commit();
            return true;
        }else{
            session.getTransaction().commit();
            return false;
        }
    }

    public boolean deleteAccount(Account account){
        Session session = Factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List accounts = session.createQuery("from Account "+
                "where login='"+account.getLogin()+"'").getResultList();
        if(accounts.size()==0){
            return false;
        }else {
            Account checkAccount = (Account) accounts.get(0);
            if(checkAccount.getPassword().equals(account.getPassword())){
                session.delete(checkAccount);
                session.getTransaction().commit();
            }
        }
        return true;
    }

    public Account getAccount(String username){
        List accounts = findAccount(username);
        return (Account) accounts.get(0);
    }

    private List findAccount(String username){
        Session session = Factory.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List accounts = session.createQuery("from Account "+
                "where login='"+username+"'").getResultList();
        session.getTransaction().commit();
        return accounts;
    }
}
