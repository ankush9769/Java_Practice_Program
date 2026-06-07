import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Employee{
	private int id;
	private String name;
    private String dept;
    private int salary;
	private LocalDate dateOfJoining;
    
	public Employee(int id,String name,String dept,int salary,LocalDate dateOfJoining){
		this.id=id;
		this.name=name;
	    this.dept=dept;
		this.salary=salary;
		this.dateOfJoining=dateOfJoining;
	}	
	public int getId() {
      return id;
    }
	public int getsalary(){
		return salary;
	}
	public String getdept(){
		return dept;
	}
	public LocalDate getdateOfJoining(){
		return dateOfJoining;
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
		return "id="+id+" name="+name+" dept="+dept+" salary="+salary+" dateofjoining="+dateOfJoining;
	}
	
}


class EmployeeNotfoundException extends Exception{
	public EmployeeNotfoundException(String message){
		super(message);
	}	
}



public class EmpManagementSystem{
	static ArrayList<Employee> list = new ArrayList<>();
	
	public static void addEmployee(int id,String name,String dept,int salary,LocalDate dateOfJoining){
		Employee employee = new Employee(id,name,dept,salary,dateOfJoining);
		list.add(employee);
		
	}
	
	public static void showEmployee(){
		if(list.isEmpty()){
			System.out.println("employee not found");
			return;
		}
		for(Employee emp:list){
			System.out.println(emp);
		}
	}
	
	public static void updateEmployee(int id,int newsalary) throws EmployeeNotfoundException{
		for(Employee emp:list){
			if(emp.getId()==id){
				emp.setSalary(newsalary);
				System.out.println("employee salary updated");
				return;
			}
		}
		throw new EmployeeNotfoundException("employee not found for update");
	}	
	
	public static void deleteEmployee(int id) throws EmployeeNotfoundException{
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				list.remove(i);
				System.out.println("employee deleted successfully");
				return;
			}
		}
		throw new EmployeeNotfoundException("employee not found for delete");
	}
	
	public static void searchEmployee(int id) throws EmployeeNotfoundException{
		for(Employee emp:list){
			if(emp.getId()==id){
				System.out.println(emp);
				return;
			}
		}
		throw new EmployeeNotfoundException("employee not found");
	}
	
	public static void highestPaidEmployee(){
		int highestsalary = list.get(0).getsalary();
		for(Employee emp:list){
			if(emp.getsalary()>highestsalary){
				highestsalary = emp.getsalary();
			}
		}
		for(Employee emp:list){
			if(emp.getsalary()==highestsalary){
				System.out.println("highest paid Employee");
				System.out.println(emp);
			}
		}
		
	}
	
	public static void groupByDepartment(String deptname){
		for(Employee emp:list){
			if(emp.getdept().equalsIgnoreCase(deptname)){
				System.out.println(emp);
				return;
			}
			
		}
		System.out.println("no Employee found for this department="+deptname);
	}
	
	public static void searchEmployeeByDOJ(LocalDate date) throws EmployeeNotfoundException{
		for(Employee emp:list){
			if(emp.getdateOfJoining().equals(date)){
				System.out.println(emp);
				return;
			}
		}
		throw new EmployeeNotfoundException("employee not found");
	}
	
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		while(true){
		
		System.out.println("what you want to perform");
		System.out.println("press");
		System.out.println("1 for add Employee");
		System.out.println("2 for show Employee");
		System.out.println("3 for update Employee salary");
		System.out.println("4 for delete Employee");
		System.out.println("5 for search Employee by id");
		System.out.println("6 for displaying highest paid employee");
		System.out.println("7 for group Employees by department");
		System.out.println("8 for search Employee by dateOfJoining");
		int choice = sc.nextInt();
			switch(choice){
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
				LocalDate dateOfJoining = LocalDate.parse(inputdate);
				addEmployee(id,name,dept,salary,dateOfJoining);
				System.out.println("employee added successfully");
				break;
			}
			case 2:{
				showEmployee();
				break;
			}
			case 3:{
				System.out.println("enter id:");
				int id = sc.nextInt();
				
				System.out.println("enter salary");
				int newsalary = sc.nextInt();
				
				try{
					updateEmployee(id,newsalary);
				}catch(EmployeeNotfoundException e){
					System.out.println(e.getMessage());	
				}
				break;
				
			}
			case 4:{
				System.out.println("enter id:");
				int id = sc.nextInt();
				try{
					deleteEmployee(id);
				}catch(EmployeeNotfoundException e){
					System.out.println(e.getMessage());	
				}
				break;
			}
			case 5:{
				System.out.println("enter id:");
				int id = sc.nextInt();
				try{
					searchEmployee(id);
				}catch(EmployeeNotfoundException e){
					System.out.println(e.getMessage());	
				}
				break;
			}
			case 6:{
				highestPaidEmployee();
				break;
			}
			case 7:{
				System.out.println("enter department name for searching group of employee:");
				String deptname = sc.next();
				groupByDepartment(deptname);
				break;
			}
			case 8:{
				System.out.println("enter dateOfJoining:");
				String inputedate = sc.next();
				LocalDate date = LocalDate.parse(inputedate);
				try{
					searchEmployeeByDOJ(date);
				}catch(EmployeeNotfoundException e){
					System.out.println(e.getMessage());
					
				}
				break;
			}
			default: System.out.println("enter valid option");
		}	
	}
}		
}