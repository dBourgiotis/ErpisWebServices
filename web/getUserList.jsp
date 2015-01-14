<%@page import="dbTest.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="dbTest.Manager"%>
<%@page import="dbTest.User"%>
<%@page contentType="text/xml" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

    Manager m = new Manager();
    List <User> ls = m.loadUsers();
    String rxml = new String();
    
    rxml+="<users>";
    for (int i = 0; i < ls.size(); ++i){
        rxml+="<user>";
        rxml+="<uname>"+ls.get(i).getUname()+"</uname>";
        rxml+="<password>"+ls.get(i).getPassword()+"</password>";
        rxml+="<role>"+ls.get(i).getRole()+"</role>";
        rxml+="<id>"+ls.get(i).getId()+"</id>";
        rxml+="</user>";
 
    }
    rxml+="</users>";
    
    out.println(rxml);    
    
%>
