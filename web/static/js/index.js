$(function () {
    
    // Handle login 
    $('#submit').click(function () {
        $('#submit').addClass('disabled')
            .attr('disabled', 'disabled');
        $.ajax({
            url: 'login.jsp',
            type: 'POST',
            data: {
                username: $('#username').val(),
                password: $('#password').val()
            },
            error: function (jqXHR) {
                $('#login-error')
                    .text(jqXHR.responseText)
                    .slideDown(200);
            },
            success: function () {
                window.location.reload();
            },
            complete: function () {
                $('#submit').removeClass('disabled')
                    .attr('disabled', null);
            }
        });
    });
    
    // Hide error if user edits credentials
    // Handle "Enter" key
    $('#username, #password').on('keypress', function (e) {
        $('#login-error').slideUp(200);
        if (e.keyCode === 13)
            $('#submit').click();
    });
});
