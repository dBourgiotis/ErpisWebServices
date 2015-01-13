package helpers;

import javax.servlet.http.HttpServletRequest;
import dbTest.Manager;

public class Auth {
   
    public final static String USER = "username";
    public final static String PASS = "password";

    public boolean logIn (HttpServletRequest request) {

        Manager manager = new Manager();

        // Connect to the database and check if user exists
        Boolean exists = manager.checkUser(
            request.getParameter(USER),
            request.getParameter(PASS)
        );

        if (!exists)
            return false;

        // Save username to session so that we know
        // if a user has already logged in
        request.getSession().setAttribute(USER, request.getParameter(USER));
        
        return true;
    }
    
    public void logOut (HttpServletRequest request) {
        request.getSession().setAttribute(USER, null);
    }

    public boolean isLoggedIn (HttpServletRequest request) {
        return request.getSession().getAttribute(USER) != null;
    }
}
