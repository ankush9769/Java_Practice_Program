package org.example;

import entites.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Pagination {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Query query = session.createQuery("from User");
        query.setFirstResult(3);
        query.setMaxResults(5);
        List<User> users = query.list();
        System.out.println(users);

        tx.commit();

        //cache in hibernate(1 level,2nd level)
        //@ manay to many
        // state of hibernate
        // (n+1) problem with hiberenate

    }
}
