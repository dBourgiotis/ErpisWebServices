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
            url: 'admin.jsp',
            type: 'POST',
            data: {
               first_name: $('#first-name').val(),
               last_name: $('#last-name').val(),
               password: $('#password').val(),
               role: $('#role').val()
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
        url: 'admin.jsp',
        type: 'GET',
        success: function (xml) {
            window.x = xml;
            var users = xml.getElementsByTagName('user');
            console.log(users);
            for (var i = 0; i < users.length; i++) {
                window.a = users[i];
                createAppointment(
                    xmlToAppointment(users[i])
                );
            }
        }
    });
});

function createUser (u) {
    
    $('.dump ul').append(
        '<li id="' + u.id +'" class="bg-highlight">' +
            '<span class="id">' + u['id'] + '</span>' +
            '<span class="name">' + u['Full Name'] + '</span>' +
            '<span class="role">' + u['Role'] + '</span>' +
            '<div class="details">' +
                objectToTable(u) +
            '</div>' +
        '</li>'
    );
    $('#' + u.id).click(function () {
        $('#' + u.id + ' .details').toggle(200);
    });
}

function xmlToAppointment (xml) {
    var getEl = function (tagname) {
        return xml.getElementsByTagName(tagname);
    }
    return {
        'Full Name': getEl('fullname')[0].innerHTML,
        'Role': getEl('role')[0].innerHTML,
        'id': getEl('id')[0].innerHTML
    }
}

