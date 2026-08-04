package entites;

import jakarta.persistence.*;

@Entity
public class AnswerManyToOne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    @ManyToOne
    private QuestionOneToMany question;
    private String answer;

    public AnswerManyToOne(String answer) {
        this.answer = answer;
    }
    public AnswerManyToOne(){

    }



    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public QuestionOneToMany getQuestion() {
        return question;
    }

    public void setQuestion(QuestionOneToMany question) {
        this.question = question;
    }
}
