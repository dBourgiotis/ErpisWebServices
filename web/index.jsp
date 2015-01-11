<%@page import="helpers.Auth"%>
<%  
    Auth auth = new Auth();
    if (auth.isLoggedIn(request))
        response.sendRedirect("appointment.jsp");
    else
        response.sendRedirect("index.html");
%>
