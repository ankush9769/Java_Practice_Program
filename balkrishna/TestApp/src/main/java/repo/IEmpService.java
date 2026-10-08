package repo;

import java.util.List;

import dto.EmpDto;
import dto.Employee;
import models.Emp;
import models.Manager;

public interface IEmpService {
	
	void addEmployee(EmpDto employee);
	List<Manager> getManager();
	//void connectionCheck();
	List<Employee> getAllEmployee();
	
	

}