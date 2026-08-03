package StudentMain;

import entites.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentFindMain {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

     //   Student student = session.find(Student.class,1); // it will show null error becouse the student is null (eger initializer)
       Student student = session.getReference(Student.class,1); //it is lazy initialisation(if you use the object then only it will fethc the data and run the sql query)
//        System.out.println(student.getName());

    }
}
