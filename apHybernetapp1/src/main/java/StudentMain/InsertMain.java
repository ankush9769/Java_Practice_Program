package StudentMain;

import entites.Student;
import entites.Certificate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class InsertMain {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Certificate c = new Certificate("mysql","4month");
        Student s = new Student("shreya",c);

        session.persist(s);
        tx.commit();
    }
}
