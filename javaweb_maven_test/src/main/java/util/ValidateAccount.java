package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import dao.AccountDAO;

public class ValidateAccount {
    
    public boolean accountValidate (HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String username = "";
        String password = "";
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username = cookie.getValue();
            }
            if ("password".equals(cookie.getName())) {
                password = cookie.getValue();
            }
        }
        String[] account = {username, password};
        AccountDAO accountDAO = new AccountDAO();
        if (accountDAO.isRightAccount(account)) {
            return true;
        }
        return false;
    }
    
}
