package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
//	 String URL = "jdbc:mysql://localhost:3306/hrms";
//	String UserName  = "root";
//	String Password = "";
	
	
	
//		public static Connection getConnection() throws Exception {
////			Class.forName("com.mysql.cj.jdbc.Driver");
////			DriverManager driverManager = new DriverManager();
////			driverManager.getConnection(URL,UserName, Password);
//			return DriverManager.getConnection(URL,UserName, Password);
//			
//				
//			
//		}
	
	static String url="jdbc:mysql://localhost:3306/testapp";
	static String userName = "root";
	static String password="";
	public static Connection getConnetion() throws ClassNotFoundException, SQLException
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url,userName,password);
		if(con!=null)
		{
			System.out.println("Connection created");
		}
		return con;
		
		
	}
	
	
	

}
