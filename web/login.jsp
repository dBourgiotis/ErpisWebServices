<%@page import="helpers.Auth"%>
<%    
    String method = request.getMethod();
    
    // Redirect to login page
    if (method == "GET")
        response.sendRedirect("login.html");
    
    // Check credentials
    else if (method == "POST") {
        
        Auth auth = new Auth();  
        if (auth.logIn(request))
            response.sendRedirect("index.jsp");
        response.sendError(401, "Unauthorized");
    }
%>
