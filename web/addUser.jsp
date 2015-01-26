<%-- 
    Document   : addUser
    Created on : Jan 13, 2015, 6:46:53 PM
    Author     : it21221
--%>

<%@page import="helpers.ResponseHandler"%>
<%@page import="dbTest.Manager"%>
<%@page import="dbTest.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ResponseHandler rHandler = new ResponseHandler(
        response,
        request,
        application
    );
    
    if (rHandler.isLoggedIn()){
            
        String fname = request.getParameter("username");
        String password = request.getParameter("passworld");
        String role = request.getParameter("role");

        User myUser= new User();

        myUser.setPassword(password);
        myUser.setRole(role);
        myUser.setUname(fname);

        Manager myManager = new Manager();

        myManager.createUser(myUser);
        
        rHandler.success();
    }

    else
        rHandler.redirect("index.jsp");
%>