import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Cookie [] cookie= req.getCookies();
        boolean flag= false;
        String name= "";
        if (cookie.length==0){
            out.println("<h1>You are a new user</h1>");
        }else {
            for(Cookie cookie1: cookie){
              String Servlet2name=  cookie1.getName();
              if (Servlet2name.equals("user")){
                  flag=true;
                  name=cookie1.getValue();
                  if (flag==true){
                      out.println("Welcome "+ name);
                  }
              }
            }

        }
    }
}
