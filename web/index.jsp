<%@page import="helpers.Auth"%>
<%
    String method = request.getMethod();
    
    switch (method) {
        case "POST": {
        
        }
        case "PUT": {
             
        }
        case "GET": {
           
        }
        case "DELETE": {
        
        }
        default: {
            out.println("you are a bitch");
        }
    }
    
    Auth auth = new Auth();
    if (auth.isLoggedIn(request))
        response.sendRedirect("form.jsp");
    else
        response.sendRedirect("login.jsp");
%>
