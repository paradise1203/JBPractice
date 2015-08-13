import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "TimeChecker")
public class TimeChecker implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        String servletPath = httpRequest.getServletPath();
        System.out.println(servletPath+" : "+ new Date());
        chain.doFilter(req, resp);
    }

    public void destroy() {

    }
}
