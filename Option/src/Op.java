import java.util.Optional;

public class Op {
    public static void main (String[] args){

        String name="xyz";

        String name1="";
        Optional <String> nameOptional=Optional.of(name);
        if(nameOptional.isPresent()){
            System.out.println(nameOptional.get());
        }

        Optional <String> nameNull=Optional.ofNullable(null);
        if(nameNull.isEmpty()){
            System.out.println(nameNull.get());
        }
//        System.out.println(nameOptional);
//        System.out.println(nameNull);


    }
}
