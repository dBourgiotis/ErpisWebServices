<%-- 
    Document   : editUser
    Created on : Jan 13, 2015, 7:10:33 PM
    Author     : it21221
--%>

<%@page import="dbTest.Manager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbTest.User"%>

<%
    int id = Integer.parseInt(request.getParameter("Id"));
    
    String role = request.getParameter("New Role");   
    
    
    Manager myManager = new Manager();
    
    myManager.changeUsersRole(id, role);

%>