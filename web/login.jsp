<%-- 
    Document   : login
    Created on : Dec 28, 2014, 6:01:28 PM
    Author     : GREG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String name = request.getParameter( "username" );
session.setAttribute( "uname", name );
String pswd = request.getParameter("password");
session.setAttribute("upswd", pswd);
%>
<HTML>
<BODY>
Hello, <%= session.getAttribute( "uname" ) %>
</BODY>
</HTML>
