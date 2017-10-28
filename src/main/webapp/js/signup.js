
// OLD FORM
// /**
//  * Created by ooo on 5/29/2017.
//  */
// var $loginMsg = $('.loginMsg'),
//     $login = $('.login'),
//     $signupMsg = $('.signupMsg'),
//     $signup = $('.signup'),
//     $frontbox = $('.frontbox');
//
// $('#switch1').on('click', function() {
//     $loginMsg.toggleClass("visibility");
//     $frontbox.addClass("moving");
//     $signupMsg.toggleClass("visibility");
//
//     $signup.toggleClass('hide');
//     $login.toggleClass('hide');
// })
//
// $('#switch2').on('click', function() {
//     $loginMsg.toggleClass("visibility");
//     $frontbox.removeClass("moving");
//     $signupMsg.toggleClass("visibility");
//
//     $signup.toggleClass('hide');
//     $login.toggleClass('hide');
// })
//
// setTimeout(function(){
//     $('#switch1').click()
// },1000)
//
// setTimeout(function(){
//     $('#switch2').click()
// },3000)


//-------------------------------------------------------------------------------------------

$(document).ready(function() {
    $('#contact_form').bootstrapValidator({
        // To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            userfirstName: {
                validators: {
                    stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply your first name'
                    }
                }
            },
            userlastName: {
                validators: {
                    stringLength: {
                        min: 2,
                    },
                    notEmpty: {
                        message: 'Please supply your last name'
                    }
                }
            },
            userpassword: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your phone number'
                    }
                }
            },
            useremail: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your email address'
                    },
                    emailAddress: {
                        message: 'Please supply a valid email address'
                    }
                }
            },
            usernumberPhone: {
                validators: {
                    notEmpty: {
                        message: 'Please supply your phone number'
                    },
                    phone: {
                        country: 'US',
                        message: 'Please supply a vaild phone number with area code'
                    }
                }
            },
            useraddress: {
                validators: {
                    stringLength: {
                        min: 8,
                    },
                    notEmpty: {
                        message: 'Please supply your street address'
                    }
                }
            }
        }
    })
        .on('success.form.bv', function(e) {
            $('#success_message').slideDown({ opacity: "show" }, "slow") // Do something ...
            $('#contact_form').data('bootstrapValidator').resetForm();

            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');

            // Use Ajax to submit form data
            $.post($form.attr('action'), $form.serialize(), function(result) {
                console.log(result);
            }, 'json');
        });
});



