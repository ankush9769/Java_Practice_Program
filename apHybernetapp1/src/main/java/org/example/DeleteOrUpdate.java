package org.example;

import entites.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class DeleteOrUpdate {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        //delete
//        Query query = session.createQuery("delete from User where city=:n");
//        query.setParameter("n","mumbai");
//        int rows = query.executeUpdate();
//        System.out.println(rows);




        Query query = session.createQuery("update User set city =:c where name =:n");
        query.setParameter("c","mumbai");
        query.setParameter("n","Neha Joshi");
        int rows = query.executeUpdate();
        System.out.println(rows);
        System.out.println("update date done");

        tx.commit();
    }
}
