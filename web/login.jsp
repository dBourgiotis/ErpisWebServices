<%@page import="helpers.Auth"%>
<%
    Auth auth = new Auth();
    if (auth.isLoggedIn(request) || auth.logIn(request))
        response.sendRedirect("form.jsp");
    else
        out.println("you are a bitch");
%>


