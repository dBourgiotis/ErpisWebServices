<%-- 
    Document   : login
    Created on : Dec 28, 2014, 6:01:28 PM
    Author     : GREG
--%>

<%@page import="db.PersistanceCon"%>
<%@page import="db.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
PersistanceCon exists = new PersistanceCon();



String name = request.getParameter( "username" );
String pswd = request.getParameter("password");




/*if(exists.authCredentials(name, pswd)==null){
    out.println("Wrong input! Please, try again.");
    out.println("<a href='login.html'>Click here to go to login page</a>");
}else{
    session.setAttribute( "uname", name );
    session.setAttribute("upswd", pswd);
    //to do
};*/




%>


