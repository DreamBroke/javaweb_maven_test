package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ValidateAccount;

@WebFilter(urlPatterns={"/*"})
public class AccoutFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        switch (getRedirectPath((HttpServletRequest) request)) {
        case "continue":
            chain.doFilter(request, response);
            break;
        case "redirect-login":
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/login");
            break;
        case "redirct-hello":
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/hello");
            break;
        default:
            break;
        }
    }
    
    public String getRedirectPath(HttpServletRequest request) {
        ValidateAccount validateAccount = new ValidateAccount();
        String servletPath = request.getServletPath();
        if (((servletPath.indexOf("hello") != -1 || servletPath.equals("/")) && validateAccount.accountValidate(request)) || (servletPath.indexOf("login") != -1 && !validateAccount.accountValidate(request))) {
            return "continue";
        }
        if ((servletPath.indexOf("hello") != -1 || servletPath.equals("/")) && !validateAccount.accountValidate(request)) {
            return "redirect-login";
        }
        if (servletPath.indexOf("login") != -1 && validateAccount.accountValidate(request)) {
            return "redirct-hello";
        }
        return "";
    }

    @Override
    public void destroy() {

    }

}
