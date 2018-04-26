//检查账号是否存在
function isExist(user_phone) {

    //检验手机号码
    if (!user_phone.match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/)) {
        $("#user_phone_tip").html("请输入正确的手机号码！");
        $("#user_phone_tip").focus();
        return;
    }

    //比对数据库信息
    $.ajax({
        type: "POST",

        url: "UserServlet?method=isExist",

        cache: false,

        data: {"user_phone": user_phone},

        success: function (data) {

            var obj = jQuery.parseJSON(data);

            if (obj.header.code == 0) {
                $("#user_phone_tip").html("");
            } else {
                $("#user_phone_tip").html(obj.header.message);
            }
        },
        error: function () {
            alert("出错了");
        }
    });

}

