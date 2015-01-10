<%@page import="helpers.Auth"%>
<%    
    Auth auth = new Auth();  
    if (auth.isLoggedIn(request)) {
        response.sendRedirect("index.jsp");
    } else {
        String method = request.getMethod();
        if (method == "GET") {
            // Serve login page
            response.sendRedirect("login.html");
        } else if (method == "POST") {
            // Log user in
            if (auth.logIn(request)) {
                response.sendRedirect("index.jsp");
            } else {
                out.println("");
            }
        }
    }
%>
