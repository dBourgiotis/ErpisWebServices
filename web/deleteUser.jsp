<%-- 
    Document   : deleteUser
    Created on : Jan 13, 2015, 7:16:04 PM
    Author     : it21221
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbTest.Manager"%>
<%@page import="dbTest.User"%>

<%
    int id = Integer.parseInt(request.getParameter("Id"));     
        
    Manager myManager = new Manager();
    
    myManager.deleteUser(id);

%>