$(function () {
    $('#logout').click(function () {
        $.ajax({
            url: 'logout.jsp',
            type: 'POST',
            success: function () {
                window.location.reload();
            }
        });
    });
});
