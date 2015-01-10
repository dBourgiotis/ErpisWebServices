package helpers;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author gtsop
 */
public class ErpisUser {
   
    public final static String AUTH_USER = "username";
    public final static String AUTH_PASS = "password";
    
    public boolean isLoggedIn (HttpServletRequest request) {
        Object username = request.getSession().getAttribute(AUTH_USER);
        if (username == null)
            return false;
        if (username.toString().length() > 0)
            return true;
        return false;
    }
    
    public void logIn (HttpServletRequest request) {
        request.getSession().setAttribute(AUTH_USER,
            request.getParameter(AUTH_USER).toString());
    }
    
    public void logOut (HttpServletRequest request) {
        request.getSession().setAttribute(AUTH_USER, null);
    }
}
