import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter({"/about.jsp","/home.jsp","/index.jsp","/profile.jsp" ,"/Login.jsp"})
public class Filters implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        resp.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        resp.setDateHeader("Expires",0);
        chain.doFilter(req,resp);
    }
}
