<%@page import="helpers.Auth"%>
<%@page import="helpers.Appointment"%>
<%    
    String method = request.getMethod();
    
    // Redirect to appointment page
    if (method == "GET")
        response.sendRedirect("appointment.html");
    
    // Schedule appointment
    else if (method == "POST") {
        
        Auth auth = new Auth();
        
        // Unauthorized
        if (!auth.isLoggedIn(request)) {
            response.sendRedirect("login.jsp");
            
        } else {
            Appointment appointment = new Appointment();
            if (appointment.scheduleAppointment(request)) {
                response.setStatus(200);
                out.println("OK");
            } else {
                response.setStatus(400);
                out.println("Invalid parameters");
            }
        }   
    }
%>
