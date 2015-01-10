<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/form.css">
        <link rel="stylesheet" type="text/css" href="css/normalise.css">
        <title>Erpis | Appointment form</title>
    </head>
    <body>
        
        <header>
            <label>Erpis</label>
        </header>
        
        <main>
            <div class="form">

                <div class="field">
                    <p>Fill in all of the following fields and then click
                        "Submit" to schedule an appointment</p>
                </div>

                <div class="field">
                    <label for="amka">AMKA:</label>
                    <input id="amka" type="number" min="10000000000" max="99999999999"
                        placeholder="e.g: 12345678909">
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
                    <input id="examination" type="text" placeholder="e.g: Colonoscopy">
                </div>

                <div class="field">
                    <a class="submit">Submit</a>
                </div>
            </div>
        </main>
    </body>
</html>
