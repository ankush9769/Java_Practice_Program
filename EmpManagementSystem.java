import java.time.LocalDate;
import java.util.LinkedHashSet;

class Employee{
	private int id;
	private String name;
    private String dept;
    private int salary;
	private LocalDate dataOfJoining;
    
	public Employee(int id,String name,String dept,int salary,LocalDate dataOfJoining){
		this.id=id;
		this.name=name;
	    this.dept=dept;
		this.salary=salary;
		this.dataOfJoining=dataOfJoining;
	}	
	public int getId() {
      return id;
    }

    public void setName(String name) {
       this.name = name;
    }

    public void setDept(String dept) {
       this.dept = dept;
    }

    public void setSalary(int salary) {
      this.salary = salary;
    }
	public String toString(){
		return "id="+id+" name="+name+" dept"+dept+" salary="+salary+" dataofjoining="+dataOfJoining;
	}
}
public class EmpManagementSystem{
	public static Employee addEmployee(int id,String name,String dept,int salary,LocalDate dataOfJoining){
		Employee e1 = new Employee(id,name,dept,salary,dateOfJoining);
		return e1;
		
	}
	public static Employee upadateEmployee(int id,int salary){
		for(Employee emp:set){
			if(emp.getId()==id){
				emp.setSalary(salary);
				set.put(emp);
				break;
			}
		}
	}	
	public static void main(String[] args){
		LinkedHashSet<Employee> set = new LinkedHashSet<>();
		while(true){
			Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println("what you want to perform");
		System.out.println("press");
		System.out.println("1 for add Employeeloyee");
		System.out.println("2 fro show Employeeloyee");
		System.out.println("3 for update Employeeloyee");
		System.out.println("4 for delete Employeeloyee");
			switch(input){
			case 1: {
				System.out.println("enter id:");
				int id = sc.nextInt();
				System.out.println("enter name");
				String name = sc.next();
				System.out.println("enter department");
				String dept = sc.next();
				System.out.println("enter salary");
				int salary = sc.nextInt();
				System.out.println("enter date of joining in yyyy-mm-dd format");
				String inputdate = sc.next();
				LocalDate dataOfJoining = LocalDate.parse(inputdate);
				
				set.add(addEmployee(id,name,dept,salary,dataOfJoining));
				break;
			}
			case 2:{
				System.out.println(set);
				break;
				
			}
			default: System.out.println("enter valid option");
		}	
	}
}		
}