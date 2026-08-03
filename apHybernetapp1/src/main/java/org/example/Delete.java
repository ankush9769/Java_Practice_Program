package org.example;

import org.hibernate.Transaction;
import entites.User;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Delete {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        User user = new User();
        user.setId(4);
        session.remove(user);
        System.out.println("deleted 👍👍👍");
    }
}
