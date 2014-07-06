// VARS
var EMAIL_INPUT = "email";
var PASSWORD_INPUT = "password";
var DEFAULT_EMAIL_INPUT_VALUE;
var DEFAULT_PASSWORD_INPUT_VALUE;
var fixed = false;

$(document).ready(function () {
    // Launch Fancyboxes
    $(".fancybox").fancybox({
        'transitionIn': 'elastic',
        'transitionOut': 'elastic',
        'speedIn': 600,
        'speedOut': 200,
        'overlayShow': false
    });
    
    // Launch Scrollit
    $(function(){
    	  $.scrollIt();
    	});

    // Launch Datepicker
    $("#birth").datepicker();


    // Trigg the input reset on click
    $("#" + EMAIL_INPUT).click(function () {
        clearInput(EMAIL_INPUT, "Email");
    });
    $("#" + PASSWORD_INPUT).click(function () {
        clearInput(PASSWORD_INPUT, "Mot de passe");
    });

    // Trigg the input reset on out
    $("#" + EMAIL_INPUT).blur(function () {
        resetInput(EMAIL_INPUT, "Email");
    });
    $("#" + PASSWORD_INPUT).blur(function () {
        resetInput(PASSWORD_INPUT, "Mot de passe");
    });
    
    // Trigg the apparition of menu bar
    $(window).bind('scroll',function () {
    	if($(this).scrollTop() > 750) {
    		$("#navbar").fadeIn(300);
    	} else {
    		$("#navbar").fadeOut(300);
    	}
    });
});

/**
 * Clear the value of an input is it hasn't been modified
 */
function clearInput(input, defaultValue) {
    if ($("#" + input).val() == defaultValue) {
        $("#" + input).val("");
    }
}

/**
 * Reset the value of the input
 */
function resetInput(input, defaultValue) {
    if ($("#" + input).val() == "") {
        $("#" + input).val(defaultValue);
    }
}
