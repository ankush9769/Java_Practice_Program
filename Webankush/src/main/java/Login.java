import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import DAO.UserDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.PasswordUtil;

@WebServlet("/Login")
public class Login extends HttpServlet {
    public Login() {
        System.out.println("login constructor");
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hashPassword = PasswordUtil.hash(password);
        try {
            String name = UserDao.findByUsernameAndPassword(username, hashPassword);
            if (name != null) {
                HttpSession session = req.getSession();
                session.setAttribute("user",name);

                req.setAttribute("username",name);
                RequestDispatcher rd = req.getRequestDispatcher("profile.jsp");
                rd.forward(req,resp);
            }else{
                PrintWriter out = resp.getWriter();
                out.println(
    "<html>" +
    "<body style='background-color:#f8f9fa;'>" +
    "<h1 style='color:red; text-align:center; margin-top:100px;'>Login Failed!!!</h1>" +
    "</body>" +
    "</html>"
);
                RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
//                rd.forward(req,resp);
                rd.include(req,resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}