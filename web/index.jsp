<%@page import="helpers.Auth"%>
<%  
    Auth auth = new Auth();
    if (auth.isLoggedIn(request))
        response.sendRedirect("form.jsp");
    else
        response.sendRedirect("login.jsp");
%>
