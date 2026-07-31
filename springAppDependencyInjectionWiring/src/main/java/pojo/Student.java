package pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private String email;
    @Autowired   //this is for autowired .....comment out if you are implementing manuall injection
    @Qualifier("createAddress1")
    private Address addr;
    private Subject subject;

    public Student() {
    }

    public Student(int id, String name, String email,Address addr,Subject subject) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.addr = addr;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", addr=" + addr +
                ", subject=" + subject +
                '}';
    }
}
