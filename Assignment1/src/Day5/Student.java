package Day5;

class Student{

    int id;
    String name;
    String batchcode;
    String inname;


    Student(){


    }
    Student (int id, String name,String batchcode,String inname)
    {

        this.id=id;
        this.name=name;
        this.batchcode=batchcode;
        this.inname=inname;
    }
    public String toString(){
        return id+ " "+ name+" "+ batchcode+" "+inname;
    }
    public static void main(String[]args){

        Student s1=new Student(101,"Rohit",null,null);
        System.out.println(s1);

        Student s2=new Student(102,null,"Batch103","Pillai");
        System.out.println(s2);
    }
}


