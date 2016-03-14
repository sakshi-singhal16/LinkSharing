// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better 
// to create separate JavaScript files as needed.
//
//= require jquery
//= require_tree .
//= require_self
//=require bootstrap

function successHandler(result) {
    if (result) {
        var jsonResponseDiv = $(".jsonResponse");

        if (result.message) {

            jsonResponseDiv.text(result.message);
            jsonResponseDiv.addClass("alert alert-success");
            /*            setTimeout(function () {
                location.reload()
             }, 2000)*/

        }
        else {
            jsonResponseDiv.text(result.error);
            jsonResponseDiv.addClass("alert alert-danger");
            /*       setTimeout(function () {
             }, 2000)*/
        }
        jsonResponseDiv.css({'display': 'block'})
    }
}

$(document).ready(function () {

    $("#seriousness").change(function () {
        $.ajax({
            url: "/subscription/update",
            data: {id: $(this).attr('topicId'), seriousness: $(this).val()},
            success: successHandler
        });

    });

    $("#v").change(function () {
        $.ajax({
            url: "/topic/update",
            data: {topicName: $(this).attr('topicName'), id: $(this).attr('topicId'), visibility: $(this).val()},
            success: successHandler
        });

    });
    /*$("#createTopic").click(function () {
     //alert( $('#v').val() )
     $.ajax({
     url: "/topic/save",
     data: {topicName: $('#topicName').val(), visibility: $('#visibility').val()},
     success: successHandler
     });
     });*/

    $(".subscribe").click(function () {
        $.ajax({
            url: "/subscription/save",
            data: {topicId: $(this).attr('topicId')},
            success: successHandler
        });
    });
    $(".unsubscribe").click(function () {
        $.ajax({
            url: "/subscription/delete",
            data: {topicId: $(this).attr('topicId')},
            success: successHandler
        });
    });

    $(".markReadStatus").click(function () {
        $.ajax({
            url: "/readingItem/changeIsRead",
            data: {resourceId: $(this).attr('resourceId'), isRead: $(this).attr('isRead')},
            success: location.reload()
        });
    });
    $("#editTopicIcon").click(function () {
        $("#editTopicForm").css({'display': 'block'})
    })
    $("#cancelButton").click(function () {
        $("#editTopicForm").css({'display': 'none'})
    })
});