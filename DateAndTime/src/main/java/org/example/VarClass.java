package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class VarClass {
    public static void main(String[] args){
        var name = "hello";

        var arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        System.out.println(arr);

        var hashmap = new HashMap<>();
        hashmap.put("ankush",21);
        hashmap.put("shreya",40);
        System.out.println(hashmap);
    }
}
