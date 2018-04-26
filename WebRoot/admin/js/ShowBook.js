//显示所有书籍信息
$(function () {
    $('#dg').datagrid({
        url: 'BookServlet?method=queryBook&tableName=b_book',
        fitColumns: true,
        singleSelect: true,
        pagination: true,
        nowrap: false,
        rownumbers: true,
        pageSize: 10,
        pageList: [10, 20, 30],
        onAfterEdit: editRow,
        columns: [[
            {
                field: 'book_id',
                title: '书籍编号',
                align: 'center'
            }, {
                field: 'book_img_id',
                title: '图片编号',
                align: 'center'
            }, {
                field: 'book_name',
                title: '书名',
                width: 100,
                editor: 'text',
                align: 'center'
            }, {
                field: 'book_author',
                title: '作者',
                width: 150,
                editor: 'text',
                align: 'center'
            }, {
                field: 'book_translate',
                title: '译者',
                width: 150,
                editor: 'text',
                align: 'center'
            }, {
                field: 'book_price',
                title: '单价',
                editor: 'text',
                align: 'center'
            }, {
                field: 'book_type',
                title: '类型',
                editor: 'text',
                width: 80,
                align: 'center'
            }, {
                field: 'book_publish',
                title: '出版社',
                width: 150,
                editor: 'text',
                align: 'center'
            }, {
                field: 'book_published_time',
                title: '出版时间',
                editor: 'text',
                width: 100,
                align: 'center'
            }, {
                field: 'book_description',
                title: '描述',
                width: 300,
                editor: 'text',
                align: 'center'
            }, {
                field: 'images',
                title: '图片',
                align: 'center',
                width: 100,
                formatter: function (value, row, index) {
                    return '<img src=' + row.file_path + ' width="100px" height="100px"/>';
                }
            }
        ]]
    }).datagrid('enableCellEditing').datagrid('gotoCell', {index: 0, field: 'book_id'});

});

//编辑
function editRow(index, row, changes) {
    $.ajax({
        type: "POST",
        url: "BookServlet?method=editBook&row=[" + JSON.stringify(row) + "]",
        cache: false,
        data: null,
        success: function (data) {
            var obj = jQuery.parseJSON(data);
            alert(obj.header.message);
            $('#dg').datagrid('reload');
        },
        error: function (data) {
            alert("编辑失败！！");
        }
    });

}

//添加
function add_data() {
    $('#dialog_add_edit').dialog({
        title: '书籍上架',
        id: "dialog_add_edit",
        width: 400,
        height: 350,
        modal: true,
        buttons: [{
            text: '确定',
            handler: function () {
                if (!$("#addEditForm").form("validate")) {
                    return;
                } else {
                    var Formdata = $('#addEditForm').serialize();
                    $.ajax({
                        type: "POST",
                        url: "	BookServlet?method=addBook",
                        cache: false,
                        data: Formdata,
                        success: function (data) {
                            var obj = jQuery.parseJSON(data);
                            alert(obj.header.message);
                            location.href = "admin/addBookImg.jsp";
                        },
                        error: function () {
                            alert("error");
                        }
                    });
                }
            }
        }, {
            text: '取消',
            handler: function () {
                $("#dialog_add_edit").dialog("close");
            }
        }]
    });
}