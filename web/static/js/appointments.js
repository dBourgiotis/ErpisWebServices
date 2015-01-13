$(function () {
   
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
            complete: function (jqXHR) {
                window.j = jqXHR;
                console.log('yolo');
            }
        });
    });
});


function showPopup () {
    $('.overlay').fadeIn(100);
    $('.popup').css('left',
        ($(window).width() / 2) -
        ($('.popup').width() / 2)
    ).fadeIn(100);
}

function hidePopup () {
       $('.overlay').fadeOut(100);
       $('.popup').fadeOut(100);
}