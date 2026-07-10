import collectionPractice.EmpByAge;
import collectionPractice.EmpByName;
import collectionPractice.Employee;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
static void main(){
    Employee e1 = new Employee(1,"shreya",25);
    Employee e2 = new Employee(2,"ankush",21);

    ArrayList list = new ArrayList();
    list.add(e1);
    list.add(e2);

    Collections.sort(list,new EmpByAge());
    System.out.println(list);
    Collections.sort(list,new EmpByName());
    System.out.println(list);




}
