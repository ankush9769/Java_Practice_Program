package Removeduplicate;

import java.util.*;

public class Removeduplicate {
    public static void main(String[] args){
        List<String> list=Arrays.asList("A", "B", "A", "C", "D", "B");
        System.out.println(list);
        Collections.singletonList(list);
        System.out.println(list);

        List<String> result = new ArrayList<>(new LinkedHashSet<>(list));
        System.out.println(result);
    }
}
