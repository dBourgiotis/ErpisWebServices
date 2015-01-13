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
});
