

import java.util.Optional;

public class optional1 {

    public static void main(String[] args) {

//        String name = "xyz";
//        Optional<String> nameOpt = Optional.of(name);
//
//        if (nameOpt.isPresent()) {
//            System.out.println(nameOpt.get());
//        }
//
//        Optional<String> nameOpt1 = Optional.ofNullable(null);
//
//        if (nameOpt1.isPresent()) {
//            System.out.println(nameOpt1.get());
//        }
//
//        Optional<String> nameOpt2 = Optional.empty();
//        System.out.println(Optional.empty().isPresent());
//        System.out.println(Optional.empty().isEmpty());
//        System.out.println(nameOpt2);

        String name3="ROhit";
        Optional<String> nameOptt = Optional.of(name3);
        if (nameOptt.isPresent()) {
            System.out.println(nameOptt.get());
        }
nameOptt.ifPresent(System.out::println);

    }
}