package collectionPractice;

import java.util.Comparator;

public class EmpByAge  implements Comparator<Employee> {
    public int compare(Employee e1,Employee e2)
    {
        return e1.getAge()-e2.getAge();
    }
}


//Comparable → comparator;
//
//comparator → compare ;


//Comparable
//__________
//comparable = java provide comparabel interface to define natural ordering for object for
//a custom class
//by implementing the comparable interface a class can provide single natural ordering that
//can be used to sort it intences

//how comparaTo() word => it return int
//which means
//        1) a -ve int will be return if current object is less than the specified object
//        2) it return 0 if the current object is equal to the specified
//        3) it return +ve int if the current object is grater than the specified obeject
//
//limitaion of the comparable
//        1) the primary limitaion is that is allows only one natural sorting for an obj of
//           the class if we want to sort a person class based on age and weight it will not
//           be possible
//
//
//Comparator
//----------
//=> this interface in java provide a way to define multiple ways to compare fiels of the obj
//        we want to sort a person class based on age and weight it will be possible