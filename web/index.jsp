<%@page import="helpers.ResponseHandler"%>
<%  
    ResponseHandler rHandler = new ResponseHandler(
        response,
        request,
        application
    );
    
    if (rHandler.isLoggedIn())
        rHandler.render("appointment.html");
    else
        rHandler.render("index.html");
%>
