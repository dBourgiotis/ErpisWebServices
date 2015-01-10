<%-- 
    Document   : login
    Created on : Dec 28, 2014, 6:01:28 PM
    Author     : GREG
--%>

<%@page import="db.PersistanceCon"%>
<%@page import="db.User"%>
<%@page import="helpers.ErpisUser"%>
<%
ErpisUser erpisUser = new ErpisUser();

if (erpisUser.isLoggedIn(request)) {
    out.println("is logged in");
} else {
   String username = request.getParameter(erpisUser.AUTH_USER);
   String password = request.getParameter(erpisUser.AUTH_PASS);
   PersistanceCon exists = new PersistanceCon();
   /*User user = exists.authCredentials(username, password);
   if (user.equals(null)) {
       out.println("Gotcah madafaka");
   } else {*/
       erpisUser.logIn(request);
       out.println("yolo");
   //}
}

//

/*if(user.equals(null)){
    out.println("Wrong input! Please, try again.");
    out.println("<a href='login.html'>Click here to go to login page</a>");
}else{*/
    //request.getSession().setAttribute("username", name);
    //to do
//};




%>


