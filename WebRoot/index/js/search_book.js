//回车事件
function KeyDown() {
    if (event.keyCode == 13) {
        search_book();
    }
}

function search_book() {
    var formData = $('#searchForm').serialize();
    var book_name = $('#book_name').val();
    if (book_name == "") {
        alert("请输入查找内容!");
        $('#book_name').focus();
        return;
    }
    //比对数据库信息
    $.ajax({
        type: "POST",
        url: "BookServlet?method=queryByName",
        cache: false,
        data: formData,
        success: function (data) {
            location.href = "index/showSearch.jsp";
        },
        error: function () {
            alert("出错了");
        }
    });

}

