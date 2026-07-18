package Same;

import org.w3c.dom.ls.LSOutput;

public class Driver {
    public static void main(String[] args) {
        Object obj = new Employee();


        if(obj instanceof  Employee emp){
            System.out.println(emp.getName());
        }
    }
}