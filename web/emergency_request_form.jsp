<%@page import="helpers.Auth"%>
<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="db.PersistanceCon"%>
<%@page import="db.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
    String str_amka = request.getParameter( "amka" );
    int amka = Integer.parseInt(str_amka);
        out.print(amka);
    
 /*
String method = request.getMethod();
    
// Redirect to appointment page
if (method == "GET")
    response.sendRedirect("emergency_request_form.html");
    
// Schedule appointment
else if (method == "POST") {
        
    Auth auth = new Auth();
     
    // Unauthorized
    if (!auth.isLoggedIn(request)) {
        response.sendRedirect("login.jsp");
            
    } else {   
        String str_amka = request.getParameter( "amka" );
        String dt1 = request.getParameter( "new_date" );
        String dt2 = request.getParameter("new_time");
        String rsn = request.getParameter("reason"); 
        int amka = Integer.parseInt(str_amka);
        out.print(amka);
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {     
            dateFormat.parse(dt1.trim());
        } catch (ParseException pe) {
            out.println("Wrong input! Please, try again.");
            out.println("<a href='emergency_request_form.html'>Click here to go back</a>");
        }
    
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
        dateFormat2.setLenient(false);
        try {
            dateFormat2.parse(dt2.trim());
        }catch (ParseException pe) {
            out.println("Wrong input! Please, try again.");
            out.println("<a href='emergency_request_form.html'>Click here to go to back</a>");
        }
        
        
        //insert data into database
    }
}
    /*
    String dt1 = request.getParameter( "new_date" );
        String dt2 = request.getParameter("new_time");
        String rsn = request.getParameter("reason"); 
    
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        try {     
            dateFormat.parse(dt1.trim());
        } catch (ParseException pe) {
            out.println("Wrong input! Please, try again.");
            out.println("<a href='emergency_request_form.html'>Click here to go back</a>");
        }
    
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
        dateFormat2.setLenient(false);
        try {
            dateFormat2.parse(dt2.trim());
        }catch (ParseException pe) {
            out.println("Wrong input! Please, try again.");
            out.println("<a href='emergency_request_form.html'>Click here to go to back</a>");
        }
        
        
        //insert data into database
    
    
    */
    
    
    
%>