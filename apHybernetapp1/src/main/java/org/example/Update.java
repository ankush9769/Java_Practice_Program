package org.example;

import org.hibernate.Transaction;
import entites.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class Update {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        User user = session.find(User.class,3);
        user.setGender("female");
        session.persist(user);
        tx.commit();



    }

}
