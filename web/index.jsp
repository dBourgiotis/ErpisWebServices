<%@page import="helpers.ResponseHandler"%>
<%  
    ResponseHandler rHandler = new ResponseHandler(
        response,
        request,
        application
    );
    
    if (rHandler.isLoggedIn())
        rHandler.redirect("appointments.jsp");
    else
        rHandler.render("index.html");
%>
