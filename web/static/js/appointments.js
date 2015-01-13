$(function () {
   
    $('.create').click(function () {
       showPopup();
    });
    
    $('.overlay, .popup .close').click(function () {
        hidePopup();
    });
});


function showPopup () {
    $('.overlay').fadeIn(150);
    $('.popup').css('left',
        ($(window).width() / 2) -
        ($('.popup').width() / 2)
    ).fadeIn(150);
}

function hidePopup () {
       $('.overlay').fadeOut(150);
       $('.popup').fadeOut(150);
}