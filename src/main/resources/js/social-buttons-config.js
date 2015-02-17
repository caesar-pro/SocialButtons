/**
 * @author Caesar pro
 */
AJS.toInit(function ($) {
    AJS.$(document).ready(function () {

        $("input[name=skin]:radio").change(function () {
            $.ajax({url: AJS.contextPath() + "/rest/socialbuttons/1.0/config/setSkin/" + $(this).val(), async: false}).done(function (data) {
                console.log("setSkin ok");

                updatePreview();
            });
        });

        $("input[name=counters]").change(function() {
            var checked = false;
            if($(this).is(":checked")) {
                checked = true;
            }

            $.ajax({url: AJS.contextPath() + "/rest/socialbuttons/1.0/config/setShowCounters/" + checked, async: false}).done(function (data) {
                console.log("showCounters ok");

                updatePreview();
            });
        });

        $("input[name=replaceLike]").change(function() {
            var checked = false;
            if($(this).is(":checked")) {
                checked = true;
            }

            $.ajax({url: AJS.contextPath() + "/rest/socialbuttons/1.0/config/setReplaceLikeBtn/" + checked, async: false}).done(function (data) {
                console.log("setReplaceLikeBtn ok");

                updatePreview();
            });
        });

        $(".site-name").change(function() {
            var checked = false;
            if($(this).is(":checked")) {
                checked = true;
            }

            console.log($(this).attr("name"));

            $.ajax({url: AJS.contextPath() + "/rest/socialbuttons/1.0/config/changeButton/" + $(this).attr("name") + "/" + checked, async: false}).done(function (data) {
                console.log("changeButton ok");

                updatePreview();
            });
        });

        updatePreview();
    });
});

function updatePreview() {
    $.ajax({url: AJS.contextPath() + "/rest/socialbuttons/1.0/config/getButtons", async: false}).done(function (data) {
        //console.log(data);
        $("#buttons-preview").html(data["html"]);
        $(".social-likes").socialLikes();
    });
}
