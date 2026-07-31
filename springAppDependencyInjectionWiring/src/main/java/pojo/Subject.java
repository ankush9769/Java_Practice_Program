package pojo;

import java.util.List;

public class Subject {
    private List<String> subject;

    public Subject(List<String> subject) {
        this.subject = subject;
    }
    public Subject(){
    }


    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject=" + subject +
                '}';
    }
}
