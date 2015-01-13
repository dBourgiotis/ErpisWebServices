
<%@page import="helpers.Auth"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="dbTest.Manager"%>
<%@page import="dbTest.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   
    
    
 
String method = request.getMethod();
    
// Redirect to appointment page
if (method == "GET")
    response.sendRedirect("emergency.html");
    
// Schedule appointment
else if (method == "POST") {
        
    Auth auth = new Auth();
     
    // Unauthorized
    if (!auth.isLoggedIn(request)) {
        response.sendRedirect("login.jsp");
            
    } else {   
        
        String str_ap_ad = request.getParameter( "appointment_id" );
        int ap_id = 0;
        String dt1 = request.getParameter( "date" );
        String rsn = request.getParameter("reason"); 
        Date dt = new Date();
    
    
    
        try{
            ap_id = Integer.parseInt(str_ap_ad);
        } catch (NumberFormatException e){
            out.println("Wrong input! Please, try again.");
            out.println("<a href='emergency_request_form.html'>Click here to go back</a>");
        }
   
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
        dateFormat.setLenient(false);
        try {     
            dt = dateFormat.parse(dt1.trim());
        } catch (ParseException pe) {
            out.println("Wrong input! Please, try again.");
            out.println("<a href='emergency_request_form.html'>Click here to go back</a>");
        }
    
        
        
        
        //insert data into database
        Manager m = new Manager();
        /*h tha prepei h addEmergency na dexetai ena String (enwmena ta dt1 kai dt2) h tha prepei na
        dexetai 2 Date (hmeromhnia kai wra)
        */
       // m.addEmergency(ap_id, rsn, dt.getTime());
        
        
       
    }
}
    
    
    
    
    
    
    
    
%>