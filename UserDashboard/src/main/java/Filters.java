import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter({"/profile.jsp","/login.jsp","/logoutpage.jsp","/Logout","/register","/Login"})
public class Filters implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filteration---------");
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        resp.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        resp.setDateHeader("Expires",0);
        chain.doFilter(req,resp);
    }
}
