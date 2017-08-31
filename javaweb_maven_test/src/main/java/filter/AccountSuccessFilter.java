package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ValidateAccount;
public class AccountSuccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        ValidateAccount validateAccount = new ValidateAccount();
        if (!validateAccount.accountValidate((HttpServletRequest) request)) {
            chain.doFilter(request, response);
        } else {
            ((HttpServletResponse)response).sendRedirect(((HttpServletRequest)request).getContextPath() + "/hello");
        }
    }

    @Override
    public void destroy() {
        
    }

}
