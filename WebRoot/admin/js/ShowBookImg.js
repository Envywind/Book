//显示所有书籍信息
$(function () {
    $('#dg').datagrid({
        url: 'BookServlet?method=queryImg&tableName=b_book_file',
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        pageSize: 10,
        pageList: [10, 20, 30],
        columns: [[{
            field: 'book_id',
            title: '书籍编号',
            width: 50,
            align: 'center'
        }, {
            field: 'book_img_id',
            title: '图片编号',
            width: 50,
            align: 'center'
        }, {
            field: 'book_img_name',
            title: '图片名称',
            editor: 'text',
            width: 100,
            align: 'center'
        }, {
            field: 'upload_user',
            title: '上传用户',
            width: 100,
            align: 'center'
        }, {
            field: 'upload_time',
            title: '上传时间',
            width: 150,
            align: 'center'
        }, {
            field: 'file_size',
            title: '大小',
            width: 100,
            align: 'center'
        }, {
            field: 'file_type',
            title: '类型',
            editor: 'text',
            width: 50,
            align: 'center'
        }, {
            field: 'file_path',
            title: '图片路径',
            width: 400,
            align: 'center'
        }, {
            field: 'images',
            title: '图片',
            align: 'center',
            width: 100,
            height: 100,
            formatter: function (value, row, index) {
                return '<img src=' + row.file_path + ' width="100px" height="100px"/>';
            }
        }]]
    });
});