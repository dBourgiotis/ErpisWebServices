$(function () {
   
    $('.create').click(function () {
       showPopup();
    });

    $('.overlay, .popup .close').click(function () {
        hidePopup();
    });
    
    $(".datepicker").datepicker();
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