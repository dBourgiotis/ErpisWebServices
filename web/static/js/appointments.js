$(function () {
   
    $('.form input').on('keypress', function () {
        hideError();
    });
    
    $('.create').click(function () {
       showPopup();
    });
    
    $('.overlay, .popup .close').click(function () {
        hidePopup();
    });
    
    $('#submit').click(function () {
        $.ajax({
            url: 'appointments.jsp',
            type: 'POST',
            data: {
               amka: $('#amka').val(),
               first_name: $('#first-name').val(),
               last_name: $('#last-name').val(),
               insurance: $('#insurance').val(),
               examination: $('#examination').val()
            },
            success: function () {
                hidePopup();
            },
            error: function (jqXHR) {
                showError(jqXHR.responseText);
            },
            complete: function (jqXHR) {
                
            }
        });
    });
    
    $.ajax({
        url: 'getAppointments.jsp',
        type: 'GET',
        success: function (xml) {
            window.x = xml;
            var appointments = xml.getElementsByTagName('appointment');
            console.log(appointments);
            for (var i = 0; i < appointments.length; i++) {
                window.a = appointments[i];
                createAppointment(
                    xmlToAppointment(appointments[i])
                );
            }
        }
    });
});

function createAppointment (a) {
    
    $('.dump ul').append(
        '<li id="' + a.id +'" class="bg-highlight">' +
            '<span class="id">' + a['id'] + '</span>' +
            '<span class="name">' + a['Full Name'] + '</span>' +
            '<span class="insurance">' + a['Insurance'] + '</span>' +
            '<div class="details">' +
                objectToTable(a) +
            '</div>' +
        '</li>'
    );
    $('#' + a.id).click(function () {
        $('#' + a.id + ' .details').toggle(200);
    });
}

function xmlToAppointment (xml) {
    var getEl = function (tagname) {
        return xml.getElementsByTagName(tagname);
    }
    return {
        'Full Name': getEl('fullname')[0].innerHTML,
        'Insurance': getEl('insurance_name')[0].innerHTML,
        'id': getEl('id')[0].innerHTML,
        'userId': getEl('userid')[0].innerHTML,
        'AMKA': getEl('amka')[0].innderHTML,
        'Emergency Reason': getEl('emergency_reason')[0].innerHTML,
        'Examination': getEl('examination')[0].innerHTML,
        'Appointment Date': getEl('date')[0].innerHTML,
        'Emergency Date': getEl('emergency_date')[0].innerHTML,
        'Medical Office': getEl('medical_office')[0].innderHTML
    }
}

