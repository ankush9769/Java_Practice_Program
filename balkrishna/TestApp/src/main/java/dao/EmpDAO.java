package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.EmpDto;
import dto.Employee;
import models.Emp;
import models.Manager;
import repo.IEmpService;
import util.DbConnection;

public class EmpDAO implements IEmpService{
	private Connection cn ;
	public EmpDAO() {
		try {
			cn= DbConnection.getConnetion();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	};
	
	@Override
	public void addEmployee(EmpDto employee) {
		String sql ="{call addEmp(?,?,?)}";
		try(CallableStatement st = cn.prepareCall(sql);){
			System.out.println(employee.getName());
			
			st.setString(1, employee.getName());
			st.setDouble(2, employee.getSalary());
			st.setInt(3, employee.getmId());
			
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Manager> getManager() {
		// TODO Auto-generated method stub
		return null;
	}


	public void connectionCheck() 
	{
		
		System.out.println("Connection Success");
	}

//
//	@Override
//	public List<Manager> getManager() {
//		// TODO Auto-generated method stub
//		
//		List<Manager> manager =new ArrayList<>();
//		
//		String sql="select * from Manager";
//		try {
//			Connection  con = dbConnection.getConnection();
//		}
//		
//		
//		
//	}

	public List<Manager> getAllManagers()  
	{
		String sql = "select * from Manager";
		List<Manager> managers = new ArrayList<>();
	
		try(Connection con = DbConnection.getConnetion();
			PreparedStatement pre = con.prepareStatement(sql))
		{
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
////				manager1.setMid(rs.getInt("mid"));
////				manager1.setMname(rs.getString("mname"));
//				//manager1.();
////				
		managers.add(new Manager(rs.getInt("mid"),rs.getString("mname")));
			}
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return managers;
	}
	
	public List<Employee> getAllEmployee(){
		
		String sql = "{CALL sp2_fetchRecords()}";
		
		List<Employee> list = new ArrayList<>();
		
		try(CallableStatement st = cn.prepareCall(sql);
		){
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				list.add(
						new Employee(
								rs.getInt("eid"),
								rs.getString("ename"),
								rs.getDouble("esalary"),
								rs.getString("mname")
						));
				
//				Employee emp= new Employee()
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	

}
