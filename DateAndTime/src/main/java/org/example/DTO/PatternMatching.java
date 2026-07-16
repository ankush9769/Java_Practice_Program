package org.example.DTO;

public class PatternMatching {
    public static void main(String[] args){
        Object obj = "hello java";
        if(obj instanceof String){
            String var = (String)obj;
            System.out.println(var.toUpperCase());
        }

        Object obj1 = "how are you";

//        public boolean equal(Object obj){
//            if(obj instanceof Emp){  //If obj is an instance of employee then we can do downcast.
//                Emp e = (Emp)obj;  // download cast to the Emp
//            }
//        }
//
//        //same things in the more sorted form
//        if(obj instanceof Emp e)+

    }
}
