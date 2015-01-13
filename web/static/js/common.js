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