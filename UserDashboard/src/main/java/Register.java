import DAO.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.Operation;
import util.PasswordUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

@WebServlet("/register")
public class Register extends HttpServlet {
    public Register(){
        System.out.println("hello");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init initialized");
    }

    @Override
    public void destroy() {
        System.out.println("destroy service");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service running");
        PrintWriter out = resp.getWriter();
        resp.setContentType("Text/html");

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        String city = req.getParameter("city");
        String hashPassword = PasswordUtil.hash(password);
        boolean isregister =  UserDao.create(name,email,hashPassword,gender,city);

        if(isregister){
            out.println(
                    "<html><body style='font-family:Arial;text-align:center;background:#f4f4f4;padding-top:100px;'>" +
                            "<h1 style='color:green;'>Hello " + name + "!</h1>" +
                            "<h2 style='color:blue;'>Registration Successful</h2>" +
                            "<a href='login.jsp'>Login Here</a>" +
                            "</body></html>"
            );

            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.include(req,resp);
            String to = email;
            String subject ="Congratulations successfully registered";
            String message = "hey "+name+" You have successfully registered. Congratulations!!!";
            try{
                Operation.sendMail(to,subject,message);
                resp.getWriter().println("mail sent successfully");
            }catch (Exception e){
                e.printStackTrace();
                resp.getWriter().println("failed to send mail");
            }

        }else{
            out.println(
                    "<html><body style='font-family:Arial;text-align:center;background:#f4f4f4;padding-top:100px;'>" +
                            "<h2 style='color:red;'>Registration Failed</h2>" +
                            "<a href='register.jsp'>Try Again</a>" +
                            "</body></html>"
            );

            RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
            rd.forward(req,resp);
        }
    }
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("enter the username =");
//
//
//    }
}
