package QuestionAnsMain;
import entites.Question;
import entites.Answer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class Main {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Answer a = new Answer("elephant");
        Question q = new Question("who is bighest animal",a);

        session.persist(a);
        session.persist(q);
        System.out.println("done answer");
        tx.commit();
    }
}
