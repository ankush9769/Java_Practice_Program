package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pojo.Employee;

@Configuration
public class SpringConfig {
    @Bean
    public Employee emp1(){ //access by using function name
        Employee e = new Employee();
        e.setId(101);
        e.setName("ankush");
        e.setSal(10000);
        e.setAddr("kandivali");
        return e;
    }


    @Bean(name = "emps2")  //by using name
    public Employee emp2(){
        Employee e = new Employee();
        e.setId(102);
        e.setName("shreya");
        e.setSal(20000);
        e.setAddr("nalasopara");
        return e;
    }
}
