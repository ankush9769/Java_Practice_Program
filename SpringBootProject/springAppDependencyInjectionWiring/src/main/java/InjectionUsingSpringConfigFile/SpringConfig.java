package InjectionUsingSpringConfigFile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.Address;
import pojo.Student;
import pojo.Subject;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringConfig {
    @Bean
    public Student createStudent(){
        Student st1 = new Student();
        st1.setId(101);
        st1.setName("ankush");
        st1.setEmail("ankush@gmail.com");
    //    st1.setAddr(createAddress());   //this is for autowired .....uncomment out if you are implementing manuall injection
        st1.setSubject(createSubject());

        return st1;
    }



    @Bean
    public Address createAddress1(){
        Address ad1 = new Address();
        ad1.setHouseNO(201);
        ad1.setRoadNo(301);
        ad1.setStreet("lalachauk");
        return ad1;
    }

    @Bean
    public Address createAddress2(){
        Address ad1 = new Address();
        ad1.setHouseNO(201);
        ad1.setRoadNo(301);
        ad1.setStreet("lalachauk");
        return ad1;
    }


    @Bean
    public Subject createSubject(){
        Subject sub1 = new Subject();
        List<String> subs = new ArrayList<>();
        subs.add("maths");
        subs.add("science");
        subs.add("cs");
        sub1.setSubject(subs);
        return sub1;
    }
}
