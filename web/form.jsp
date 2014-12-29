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
        <link rel="stylesheet" type="text/css" href="css/normialise.css">
        <title>Appointment form</title>
    </head>
    <body>
        <p>some instructions here...</p>
        
        <div class="field">
            <label for="amka">AMKA:</label>
            <input id="amka" type="number" min="10000000000" max="99999999999"
                placeholder="12345678909">
        </div>
        
        <div class="field">
            <label for="first-name">First Name:</label>
            <input id="first-name" type="text" placeholder="e.g: George">
        </div>
        
        <div class="field">
            <label for="last-name">Last Name:</label>
            <input id="last-name" type="text" placeholder="e.g: Papadopoulos">
        </div>
            
        <div class="field">
            <label for="insurance">Insurance:</label>
            <input id="insurance" type="text" placeholder="e.g: Erpis Insurance Co">
        </div>
        
        <div class="field">
            <label for="examination">Examination:</label>
            <input id="examination" type="text" placeholder="e.g: colonoscopy">
        </div>
        
        <div class="field">
            <a class="submit">Submit</a>
        </div>
    </body>
</html>
