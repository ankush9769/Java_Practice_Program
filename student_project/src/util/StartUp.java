package util;

import DAO.StudentDAO;
import model.Student;

import java.util.Scanner;

public class StartUp {
    public static void insert(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter id:");
        int id = sc.nextInt();
        System.out.println("enter name:");
        String name  = sc.next();
        System.out.println("enter the course");
        String course = sc.next();
        System.out.println("enter the marks");
        int marks = sc.nextInt();
        Student s = new Student(id,name,course,marks);
        StudentDAO.insert(s);
    }
    public static void update(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the id of the sudent for update the marks");
        int reqid = sc.nextInt();
        System.out.println("enter updated marks");
        int reqmarks = sc.nextInt();
        StudentDAO.update(reqid,reqmarks);
    }
    public static void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the id of the sudent for deleting the record");
        int delid = sc.nextInt();
        StudentDAO.delete(delid);
    }




    public static void start(){
        System.out.println("hello how are you");
        int input;
        do{
            System.out.println("welcome to student management system");
            System.out.println("press 1 for register student");
            System.out.println("press 2 for find all student");
            System.out.println("press 3 for update the student by id");
            System.out.println("press 4 for delete the student by id");
            Scanner sc = new Scanner(System.in);
            input = sc.nextInt();

            switch (input){
                case 1:
                    insert();
                    break;
                case 2:
                    StudentDAO.view();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                default:
                    System.out.println("enter valid input");
            }
        }
        while(input != 0);
    }
}
