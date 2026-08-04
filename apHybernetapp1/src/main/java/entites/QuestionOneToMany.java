package entites;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class QuestionOneToMany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String question;
    @JoinTable(name = "QuestionAnswerJoin")
    @OneToMany
    private List<AnswerManyToOne> answer;

    public void setAnswer(List<AnswerManyToOne> answer) {
        this.answer = answer;
    }

    public QuestionOneToMany(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }



}
