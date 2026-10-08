package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.EmpService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import dto.EmpDto;
import dto.Employee;

/**
 * Servlet implementation class EmpController
 */
@WebServlet("/EmpController")
public class EmpController extends HttpServlet {
	
	EmpService empservice1=new EmpService();
	Gson gson=new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public EmpController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter res=response.getWriter();
		String action=request.getParameter("action");
		if(action.equals("getEmp"))
		{
			var emps=empservice1.getAllEmployeeSalaryGetter();
			String s=gson.toJson(emps);
			res.write(s);
			return;
		}
		else if(action.equals("getManager")) {
			var manager=empservice1.getManager();
			String s=gson.toJson(manager);
			res.write(s);
			return;
		}
		
		
		
		
		
//		System.out.println(empservice1.getManager());
//		
//		
//		request.setAttribute("managers", empservice1.getManager());
//		request.setAttribute("employees" ,empservice1.getAllEmployeeSalaryGetter());
//		
//		List<Employee> emplist	=empservice1.getAllEmployeeSalaryGetter();
//		System.out.println("emplist"+emplist);
//		RequestDispatcher rd= request.getRequestDispatcher("employeeList.jsp");
//		rd.forward(request, response);
//	    request.getRequestDispatcher("test.jsp")
//	    .forward(request, response);
//		System.out.println("hello");
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * int noofrecords = Integer.parseInt(request.getParameter("noofrecord"));
		 * if(noofrecords != 0) {
		 * 
		 * }
		 */
		
		
		
		String action = request.getParameter("action");
		if(action.equals("addEmp")) {
			System.out.println("yeh it comming to controller");
			String name = request.getParameter("name");
			double salary= Double.parseDouble(request.getParameter("salary"));
			int mid = Integer.parseInt(request.getParameter("mid"));
			System.out.println(mid);
			if((name!= null|| !name.isBlank()) && salary>0) {
				EmpDto dto = new EmpDto();
				dto.setName(name);
				dto.setSalary(salary);
				dto.setmId(mid);
				empservice1.addEmp(dto);
				String s = gson.toJson("Emp Added");
				response.getWriter().write(s);
		}
		
	}
		doGet(request, response);
	}
	
	

}
