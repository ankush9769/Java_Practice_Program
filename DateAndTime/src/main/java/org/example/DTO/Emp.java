package org.example.DTO;

public class Emp {
    private final int id;
    private final String name;
    private final String dept;

    public Emp(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }


    public static  void main(String[] args){
        Emp e = new Emp(101,"ankush","IT");
        System.out.println(e.getDept());
    }





}
