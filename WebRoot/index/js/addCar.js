//添加到购物车
function addCar(ID) {
    var ID = $('#book_id').val();

    $.ajax({
        type: "POST",
        url: "CarServlet?method=addCar",
        cache: false,
        data: {ID: ID},
        success: function (data) {
            var obj = jQuery.parseJSON(data);
            alert(obj.header.message);
            location.reload();
        },
        error: function () {
            alert("出错了");
        }
    });

}

