package pojo;



public class Student {
    private int id;
    private String name;
    private String email;
//    @Autowired   //this is for autowired .....comment out if you are implementing manuall injection
    private Address addr;

    public Student() {
    }

    public Student(int id, String name, String email,Address addr){
        this.id = id;
        this.name = name;
        this.email = email;
        this.addr = addr;
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


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", addr=" + addr +
                '}';
    }
}
