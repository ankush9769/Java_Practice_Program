import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name= req.getParameter("name");

        PrintWriter out = resp.getWriter();
//        out.println("<h1>Welcome " +name+ "</h1>" +
//                "<h1><a href='servlet2?"+name+">Servlet2</a></h1>"
//                );


        out.println("<!DOCTYPE html>"
                +"<h1>Welcome " +name+ "</h1>"
                + "<form action='servlet2' method='get'>"
                + "<input type='hidden' name='user' value="+name+"/><br><br>"
                + "<button type='submit'>go to servlet2</button>"
                + "</form>"
                + "</body>"
                + "</html>");

//        Cookie cookie= new Cookie("user",name);
//        resp.addCookie(cookie);

    }
}
