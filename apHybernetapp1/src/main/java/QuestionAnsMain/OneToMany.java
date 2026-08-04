package QuestionAnsMain;

import entites.AnswerManyToOne;
import entites.QuestionOneToMany;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class OneToMany {
    public static void main(String[] args) {
        Session session = new Configuration().configure("Hibernate.cfg.xml").buildSessionFactory().openSession();

        Transaction tx = session.beginTransaction();
//        AnswerManyToOne a = new AnswerManyToOne();
//        a.setAid(101);
//        a.setAnswer("shreya");
//
//        QuestionOneToMany q = new QuestionOneToMany();
//        q.setId(201);
//        q.setQuestion("who is equalls to milk?");
//        q.setAnswer(a);

        QuestionOneToMany q1 = new QuestionOneToMany();
        q1.setQuestion("who is as white as milk");

        AnswerManyToOne a1 = new AnswerManyToOne();
        a1.setQuestion(q1);
        a1.setAnswer("prince");

        AnswerManyToOne a2 = new AnswerManyToOne();
        a2.setQuestion(q1);
        a2.setAnswer("shreya");

        AnswerManyToOne a3 = new AnswerManyToOne();
        a3.setQuestion(q1);
        a3.setAnswer("paint");

        List<AnswerManyToOne> ans = new ArrayList<>();
        ans.add(a1);
        ans.add(a2);
        ans.add(a3);
        q1.setAnswer(ans);

        session.persist(q1);
        session.persist(a1);
        session.persist(a2);
        session.persist(a3);


        tx.commit();


    }
}
