<%-- 
    Document   : deleteUser
    Created on : Jan 13, 2015, 7:16:04 PM
    Author     : it21221
--%>

<%@page import="helpers.ResponseHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbTest.Manager"%>
<%@page import="dbTest.User"%>

<%
    ResponseHandler rHandler = new ResponseHandler(
        response,
        request,
        application
    );
    
    if (rHandler.isLoggedIn()){
        int id = Integer.parseInt(request.getParameter("id"));     

        Manager myManager = new Manager();

        myManager.deleteUser(id);
    
    }

    else
        rHandler.redirect("index.jsp");    
%>