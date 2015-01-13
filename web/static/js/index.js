$(function () {
     
    // Make login request
    $('#sign-in').click(function () {
        
        var username = $('#username').val();
        var password = $('#password').val();
        
        if (!username || !password) {
            showError("Fill in username and password");
            return;
        }
        
        disableSignIn();
        
        $.ajax({
            url: 'login.jsp',
            type: 'POST',
            data: {
                username: username,
                password: password
            },
            error: function (jqXHR) {
                showError(jqXHR.responseText);
            },
            success: function () {
                refresh();
            },
            complete: function () {
                enableSignIn();
            }
        });
    });
    
    $('#username, #password').on('keypress', function (e) {
        
        // Handle "Enter" key
        if (e.keyCode === 13)
            $('#sign-in').click();
        
        // Hide error if user edits credentials
        hideError();
    });
});

function disableSignIn () {
    $('#sign-in').addClass('disabled')
       .attr('disabled', 'disabled');
}
function enableSignIn () {
    $('#sign-in').removeClass('disabled')
        .attr('disabled', null);
}
function showError (error) {
    $('#login-error').text(error).slideDown(200);
}
function hideError () {
    $('#login-error').slideUp(200);
}
function refresh() {
    window.location.reload();
}
