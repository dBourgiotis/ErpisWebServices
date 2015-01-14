<%@page import="helpers.ResponseHandler"%>
<%  
    ResponseHandler rHandler = new ResponseHandler(
        response,
        request,
        application
    );
    
    if (rHandler.isLoggedIn()) {
        if (rHandler.isAdmin())
            rHandler.redirect("admin.jsp");
        //else if(rHandler.isSupervisor())
        //  rHandler.redirect("supervisor.jsp):
        else
            rHandler.redirect("appointments.jsp");
    }
    else {
        rHandler.render("index.html");
    }
%>
