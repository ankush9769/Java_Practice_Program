import DAO.UserDao;
import config.DatabaseConnection;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.PasswordUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

@WebServlet("/ankushserverlet")
public class MyServelet extends HttpServlet {
    public MyServelet(){
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
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hashPassword = PasswordUtil.hash(password);
        UserDao.create(name,username,hashPassword);



        String email = req.getParameter("email");
        out.println(
                "<html>" +
                "<body>" +
                "<h1> hello "+name+"!!!!</h1>" +
                "<h2>your record is successfylly added</h2>"+
                "</body>"+
                "</html"
        );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("enter the username =");


    }
}
