<%@page import="helpers.ResponseHandler"%>
<%    
    ResponseHandler rHandler = new ResponseHandler(
        response,
        request,
        application
    );
    
    if (rHandler.logOut())
        rHandler.success();
    else
        rHandler.error();
%>
