function disableButton (selector) {
    $(selector).addClass('disabled')
       .attr('disabled', 'disabled');
}
function enableButton (selector) {
    $(selector).removeClass('disabled')
        .attr('disabled', null);
}
function showError (error) {
    $('.error').text(error).slideDown(200);
}
function hideError () {
    $('.error').slideUp(200);
}
function refresh() {
    window.location.reload();
}
function showPopup (selector) {
    hideError();
    if (selector === undefined)
        selector = '';
    $('.overlay').fadeIn(150);
    $(selector + '.popup').css('left',
        ($(window).width() / 2) -
        ($('.popup').width() / 2)
    ).fadeIn(150);
}
function hidePopup () {
    $('.overlay').fadeOut(150);
    $('.popup').fadeOut(150);
}
function objectToTable (object) {
    return '<table><tbody>' +
        Object.keys(object).map(function (key) {
            if (key === 'id' || key === 'userId')
                return false;
            var value = object[key];
            if (value === null || value === undefined)
                return false;
            if (value === "null" || value === "undefined" || value === "0")
                return false;
            if (key == 'Appointment Date' || key == 'Emergency Date') {
                var date = new Date(parseInt(value));
                var hour = date.getHours();
                if (hour < 10) hour = "0" + hour;
                value = $.datepicker.formatDate('yy/mm/dd', date) +
                    ' ' + hour + ':00';
            }
            return '<tr>' +
                '<td>' + key + '</td>' +
                '<td>' + value + '</td>' +
            '</tr>';
        }).toString().replace(/false/g, '').replace(/,/g, '') +
    '</tbody></table>';
}

function createAppointment (a) {
    
    var menu = '<div class="create">'+
        'Schedule' +
    '</div>';
    var isScheduled = a['Appointment Date'] != "0";
    var addSupervisorMenu = window.isEmergency && (role == 'Supervisor');
    
    $('.dump ul').append(
        '<li id="' + a.id +'" class="bg-highlight"><div class="toggle">' +
            '<span class="id">' + a['id'] + '</span>' +
            '<span class="name">' + a['Full Name'] + '</span>' +
            '<span class="insurance">' + a['Insurance'] + '</span>' +
            (isScheduled ? '' : '<span class="not-scheduled">not schecduled!</span>') +
            (addSupervisorMenu ? '<span class="supervisor"><button class="accept">Accept</button><button class="reject">Reject</button></span>' :'') +
            '</div>' +
            '<div class="details">' +
                objectToTable(a) +
                (isScheduled? '' : menu) +
            '</div>' +
        '</li>'
    );
    $('#' + a.id + ' .toggle').click(function () {
        $('#' + a.id + ' .details').toggle(200);
    });
    $('#' + a.id + ' .create').click(function () {
        showPopup('#schedule');
        $('#schedule #ap_id').val(a.id).hide();
    });
    $('#' + a.id + ' .accept').click(function () {
        return false;
        $.ajax({
           
        });
    });
    $('#' + a.id + ' .reject').click(function () {
        return false;
        $.ajax({
           
        });
    });
}

function xmlToAppointment (xml) {
    var getEl = function (tagname) {
        return xml.getElementsByTagName(tagname);
    }
    return {
        'Full Name': getEl('fullname')[0].innerHTML,
        'Examination': getEl('examination')[0].innerHTML,
        'Medical Office': getEl('medical_office')[0].innerHTML,
        'Appointment Date': getEl('date')[0].innerHTML,
        'Emergency Reason': getEl('emergency_reason')[0].innerHTML,
        'Insurance': getEl('insurance_name')[0].innerHTML,
        'AMKA': getEl('amka')[0].innderHTML,
        'id': getEl('id')[0].innerHTML,
        'userId': getEl('userid')[0].innerHTML,
    }
}

$(function () {
    // Close popups
    $('.overlay, .popup .close').click(function () {
        hidePopup();
    });
    // Render datepickers
    $(".datepicker").datetimepicker();
});

window.role = document.cookie.split('=')[1];