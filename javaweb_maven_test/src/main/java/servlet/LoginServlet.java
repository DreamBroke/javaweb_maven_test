package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("utf-8");
	    String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String[] account = {username, password};
	    AccountDAO accountDAO = new AccountDAO();
	    boolean flag = accountDAO.isRightAccount(account);
	    if (flag) {
	        Cookie username_cookie = new Cookie("username", username);
	        username_cookie.setMaxAge(60*5);
	        Cookie password_cookie = new Cookie("password", password);
	        password_cookie.setMaxAge(60*5);
	        response.addCookie(username_cookie);
	        response.addCookie(password_cookie);
	        response.sendRedirect("hello"); 
	    } else {
	        request.setAttribute("msg", "输入的用户名密码错误，请重新输入！");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	}

}
