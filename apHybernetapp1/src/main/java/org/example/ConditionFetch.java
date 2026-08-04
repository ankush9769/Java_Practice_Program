package org.example;

import entites.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ConditionFetch {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from User where city='pune'");
        List<User> users = query.list();
        System.out.println(users);
    }
}
