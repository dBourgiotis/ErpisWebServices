

<%@page import="dbTest.User"%>
<%@page import="dbTest.Manager"%>
<%@page import="helpers.ResponseHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ResponseHandler rHandler = new ResponseHandler(
        response,
        request,
        application
    );
    
    if (!rHandler.isLoggedIn()) {
        rHandler.redirect("index.jsp");
        
    } else {
        
        String method = request.getMethod();

        if (method == "GET") {
            
            // Render Users
            rHandler.redirect("getUserList.jsp");
            
        } else if (method == "POST") {
            
            // Create user
             String fname = request.getParameter("username");
            String password = request.getParameter("password");
            String role = request.getParameter("role");

            User myUser= new User();

            myUser.setPassword(password);
            myUser.setRole(role);
            myUser.setUname(fname);

            Manager myManager = new Manager();

            myManager.createUser(myUser);
            
        } else if(method == "EDIT"){
            
            //Edit User
            int id = Integer.parseInt(request.getParameter("Id"));

            String role = request.getParameter("New Role");   


            Manager myManager = new Manager();

            myManager.changeUsersRole(id, role);
            
        } else if(method == "DELETE"){
            
            //Delete User
            int id = Integer.parseInt(request.getParameter("Id"));     

            Manager myManager = new Manager();

            myManager.deleteUser(id);
        }  
        
    }
    %>
