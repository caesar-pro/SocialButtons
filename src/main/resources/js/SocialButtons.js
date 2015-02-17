/**
 * @author Caesar pro
 */
AJS.toInit(function ($) {
    AJS.$(document).ready(function () {

        $.ajax({url: AJS.contextPath() + "/rest/socialbuttons/1.0/config/getButtons", async: true}).done(function (data) {
            //console.log(data);

            if (data["replaceLikeBtn"]) { // replace Like button
                $("#likes-section").html(data["html"]);
                $(".social-likes").socialLikes();
            } else { // show above Like button
                $("#main-content").append(data["html"]);
                $(".social-likes").socialLikes();
            }
        });

    });
});

