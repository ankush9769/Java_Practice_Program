package org.example;

import entites.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        User u1 = new User("ankush","ap7721949@gmail.com","ankush123","male","mumbai");
        User u2 = new User("shreya","ap7721949@gmail.com","ankush123","male","mumbai");

        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.persist(u1);
        session.persist(u2);
        tx.commit();

    }
}
