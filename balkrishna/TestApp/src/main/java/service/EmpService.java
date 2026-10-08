package service;

import java.util.List;

import dao.EmpDAO;
import dto.EmpDto;
import dto.Employee;
import models.Manager;

public class EmpService {
	EmpDAO dao=new EmpDAO();
	
	public void addEmp(EmpDto dto) {
		dao.addEmployee(dto);
	}
	public List<Manager> getManager(){
		return dao.getAllManagers();
	}
	
	public List<Employee> getAllEmployeeSalaryGetter(){
		
		return dao.getAllEmployee()
				.stream()
				.filter(emp -> emp.getSalary() >= 5000)
				.toList();
	}
	
	
}
