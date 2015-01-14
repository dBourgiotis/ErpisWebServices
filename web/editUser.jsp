<%-- 
    Document   : editUser
    Created on : Jan 13, 2015, 7:10:33 PM
    Author     : it21221
--%>

<%@page import="helpers.ResponseHandler"%>
<%@page import="dbTest.Manager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbTest.User"%>

<%
    ResponseHandler rHandler = new ResponseHandler(
        response,
        request,
        application
    );
    
    if (rHandler.isLoggedIn()){
    
        int id = Integer.parseInt(request.getParameter("Id"));

        String role = request.getParameter("New Role");   


        Manager myManager = new Manager();

        myManager.changeUsersRole(id, role);
    }

    else
        rHandler.redirect("index.jsp");    

%>