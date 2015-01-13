<%@page import="helpers.Appointment"%>
<%@page import="helpers.ResponseHandler"%>
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
            
            // Render appointments page
            rHandler.render("appointments.html");
            
        } else if (method == "POST") {
            
            // Schedule appointment
            Appointment appointment = new Appointment();
            if (appointment.scheduleAppointment(request)) {
                rHandler.success();
            } else {
                rHandler.error();
            }
        }
    }
%>
