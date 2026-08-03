package org.example;

import entites.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class SelectAll {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        List<User> users = session.createQuery("from User",User.class).list();
        System.out.println(users);
    }
}
