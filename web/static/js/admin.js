$(function () {
   
    
    $('.create').click(function () {
       showPopup();
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
        url: 'getUserList.jsp',
        type: 'GET',
        success: function (xml) {
            window.x = xml;
            var users = xml.getElementsByTagName('user');
            console.log(users);
            for (var i = 0; i < users.length; i++) {
                window.a = users[i];
                createUser(
                    xmlToUser(users[i])
                );
            }
        }
    });
});

function createUser (u) {
    
    $('.dump ul').append(
        '<li id="' + u.id +'" class="bg-highlight"><div class="toggle">' +
            '<span class="id">' + u['id'] + '</span>' +
            '<span class="name">' + u['Full Name'] + '</span>' +
            '<span class="role">' + u['Role'] + '</span></div>' +
            '<div class="details">' +
                objectToTable(u) +
            '</div>' +
        '</li>'
    );
    $('#' + u.id + ' .toggle').click(function () {
        $('#' + u.id + ' .details').toggle(200);
    });
}

function xmlToUser (xml) {
    var getEl = function (tagname) {
        return xml.getElementsByTagName(tagname);
    }
    return {
        'Full Name': getEl('uname')[0].innerHTML,
        'Role': getEl('role')[0].innerHTML,
        'id': getEl('id')[0].innerHTML
    }
}

