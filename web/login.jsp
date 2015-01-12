<%@page import="helpers.ResponseHandler"%>
<%    
    ResponseHandler rHandler = new ResponseHandler(
        response,
        request,
        application
    );
    
    if (rHandler.logIn())
        rHandler.redirect("appointment.jsp");
    else
        rHandler.reply("Invalid credentials", 401);
%>
