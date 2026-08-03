package org.example;

import entites.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Find {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        User user = session.find(User.class,3);
        // eager initialization , find methhod follows eager initialization
// get reference follows lazy initialization
        System.out.println("id="+user.getId());
        System.out.println("name="+user.getName());
        System.out.println("email="+user.getEmail());


        tx.commit();

    }
}
