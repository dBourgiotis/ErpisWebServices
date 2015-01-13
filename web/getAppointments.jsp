<%-- 
    Document   : getAppointments
    Created on : Jan 13, 2015, 5:08:01 PM
    Author     : GREG
--%>

<%@page import="dbTest.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="dbTest.Manager"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    Manager m = new Manager();
    List <Appointment> ls = m.loadAppointments();
    String rxml = new String();
    int i=1;
    rxml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
    
    rxml+="<appointments>";
    while(ls.isEmpty()==false){
        
        rxml+="<appointment>";
       
	rxml+="<fullname>"+ls.get(i).getFullName()+"</fullname>";
	rxml+="<insurance_name>"+ls.get(i).getInsuranceName()+"</insurance_name>";
	rxml+="<id>"+ls.get(i).getId()+"</id>";
	rxml+="<userid>"+ls.get(i).getUserId()+"</userid>";
	rxml+="<amka>"+ls.get(i).getAmka()+"</amka>";
	rxml+="<emergency_reason>"+ls.get(i).getEmergencyReason()+"</emergency_reason>";
	rxml+="<examination>"+ls.get(i).getExamination()+"</examination>";
	rxml+="<date>"+ls.get(i).getDate()+"</date>";
	rxml+="<emergency_date>"+ls.get(i).getEmergencyDate()+"</emergency_date>";
	 
        rxml+="</appointment>";
        i++;
  
    }
    rxml+="</appointments>";
    
    out.println(rxml);
    
    
    
    
    
%>
