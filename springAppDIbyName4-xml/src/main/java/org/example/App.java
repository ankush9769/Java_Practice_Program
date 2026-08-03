package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;

/**
 * Hello world!
 *
 */
import pojo.Student;
public class App 
{
    public static void main( String[] args )
    {

        String config = "ApplicationContaxt.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);  //through Application context  (through xml file)
//        ApplicationConte context = new AnnotationConfigApplicationContext(SpringConfig.class);  //Through the configuration file (Annotation)
        Student st1 = (Student) context.getBean("std1");
        System.out.println(st1);
        System.out.println( "Hello World!" );
    }
}
