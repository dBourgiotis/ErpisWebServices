<%@page import="helpers.AppointmentForm"%>
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
            AppointmentForm aForm = new AppointmentForm();
            request.setAttribute("userid", request.getSession().getAttribute("id"));
            if (aForm.scheduleAppointment(request)) {
                rHandler.success();
            } else {
                rHandler.error(aForm.getError());
            }
        }
    }
%>
