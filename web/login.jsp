<%@page import="helpers.Auth"%>
<%
    Auth auth = new Auth();
    if (auth.isLoggedIn(request))
        response.sendRedirect("index.jsp");
    else
        out.println("you are a bitch");
%>
