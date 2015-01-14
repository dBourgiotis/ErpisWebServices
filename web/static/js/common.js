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
function objectToTable (object) {
    return '<table><tbody>' +
        Object.keys(object).map(function (key) {
            if (key === 'id' || key === 'userId')
                return false;
            var value = object[key];
            if (value === null || value === undefined)
                return false;
            if (key == 'Date') {
                value = $.datepicker.formatDate('yy/mm/dd', new Date(parseInt(value)));
                //value = value.toISOString().slice(0,10).replace(/-/g,"");
            }
            return '<tr>' +
                '<td>' + key + '</td>' +
                '<td>' + value + '</td>' +
            '</tr>';
        }).toString().replace(/false/g, '').replace(/,/g, '') +
    '</tbody></table>';
}
