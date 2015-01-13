$(function () {
   
    $('.create').click(function () {
       showPopup();
    });

    $('.overlay, .popup .close').click(function () {
        hidePopup();
    });
    
    $(".datepicker").datetimepicker();;
});
