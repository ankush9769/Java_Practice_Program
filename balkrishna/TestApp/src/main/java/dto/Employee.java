package dto;

public class Employee {
	private int id;
	private String name;
	private Double salary;
	private String managerName;
	public Employee() {
		super();
	}
	public Employee(int id, String name, Double salary, String managerName) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.managerName = managerName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", managerName=" + managerName + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	
	
	
}
