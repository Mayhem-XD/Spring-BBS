// JavaScript (jQuery)
$(document).ready(function() {
    $("#uid").on("change",function() {
        let uid = $('#uid').val();
        $.ajax({
            url: "/sbbs/user/checkUid",
            type: "GET",
            data: { uid: uid },
            success: function(data) {
                 $("#uidCheckMsg").text(data);
            }
        });
    });
});
