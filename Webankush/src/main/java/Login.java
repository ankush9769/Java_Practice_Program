import DAO.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.PasswordUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
                PrintWriter out = resp.getWriter();
                out.println(
                        "<html>" +
                                "<body>" +
                                "<h1> login " + name + "successfylly!!!!</h1>" +
                                "</body>" +
                                "</html"
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}