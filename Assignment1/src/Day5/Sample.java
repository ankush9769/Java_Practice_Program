package Day5;

class Sample{
    int id;
    String name;
    String dept;
    double sal;

    Sample(){

        this.id=id;
        this.name=name;
        this.dept=dept;
        this.sal=sal;
    }
    Sample(int id,String name, String dept, double sal)
    {
        this.id=id;
        this.name=name;
        this.dept=dept;
        this.sal=sal;

    }
    public String toString(){
        return id+ " "+ name+" "+ dept+" "+sal;
    }
    public static void main(String[]args){

        System.out.println("hello");
        Sample s1= new Sample(101, "Rohiit","IT",2000.0);
        System.out.println(s1);

    }


}








