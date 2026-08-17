package org.example;

import InjectionUsingSpringConfigFile.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
//        ApplicationContext context = new ClassPathXmlApplicationContext(config);  //through Application context  (through xml file)
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);  //Through the configuration file (Annotation)
        Student st1 = (Student) context.getBean("createStudent");
        System.out.println(st1);

        System.out.println( "Hello World!" );
    }
}
