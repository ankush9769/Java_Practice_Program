package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String config = "applicationContaxt.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        Student st1 = (Student) context.getBean("std1");
        System.out.println(st1);

        Student st2 = (Student) context.getBean("std2");
        System.out.println(st2);


        System.out.println( "Hello World!" );
    }
}
