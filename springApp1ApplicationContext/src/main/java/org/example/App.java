package org.example;

import config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Employee;
//spring configuration file

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Employee em1 = (Employee) context.getBean("emp1");
        System.out.println(em1);

        Employee em2 = (Employee) context.getBean("emps2");
        System.out.println(em2);


        System.out.println( "Hello World!" );
    }
}
