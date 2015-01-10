<%-- 
    Document   : form
    Created on : Dec 29, 2014, 5:11:16 PM
    Author     : gtsop
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/form.css">
        <link rel="stylesheet" type="text/css" href="css/normalise.css">
        <title>Erpis | Appointment form</title>
        
        
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
        <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
        <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
 
        <link rel="stylesheet" href="/resources/demos/style.css" />
 
        <style>
            .datepicker{
     
        }
        </style>
 
        <script>
        $(function() {
            $( ".datepicker" ).datepicker();
        });
    </script>

    
  
    
    </head>
    <body>
        
        <header>
            <label>Erpis</label>
        </header>
        
        <main>
            <div class="form">

                <div class="field">
                    <p>Fill in all of the following fields and then click
                        "Submit" to rearrange an appointment</p>
                </div>

                <div class="field">
                    <label for="new date">New Date:</label>
                    <input id="new date" type="text" class="datepicker" 
                           placeholder="click here to choose a date">
                </div>
                
                <div class="field">
                    <label for="new time">New Time:</label>
                    <input id="new time" type="text" 
                        placeholder="e.g: 12:05">
                </div>

                <div class="field">
                    <label for="reason">Reason:</label>
                    <input id="reason" type="text" placeholder="e.g: Sudden change of plans">
                </div>

                

                <div class="field">
                    <a class="submit">Submit</a>
                </div>
            </div>
        </main>
    </body>
</html>
