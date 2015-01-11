$(function () {
    
    // Handle login 
    $('#submit').click(function () {
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
            success: function (response) {
                window.location.href = response;
            }
        });
    });
    
    // Hide error if user edits credentials
    $('#username, #password').on('keypress', function () {
        $('#login-error').slideUp(200);
    });
});
