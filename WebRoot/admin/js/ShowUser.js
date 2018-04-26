//显示用户信息
$(function () {
    var test = $(" input[ name='search_data' ] ").val();
    $('#dg').datagrid({
        url: 'UserServlet?method=queryUsers',
        queryParams: {test}, //获取表单参数传递
        fitColumns: true,
        rownumbers: true,
        pagination: true,
        pageSize: 10,
        pageList: [10, 20, 30],
        onAfterEdit: editRow,
        onLoadSuccess: function (data) {
            $('.removecls').linkbutton({
                text: '',
                plain: true,
                iconCls: 'icon-remove'
            });
        },
        columns: [[
            {
                field: 'opt',
                title: '操作',
                width: 50,
                align: 'center',
                formatter: function (val, row, index) {
                    var a;
                    if (row.status == 0) {
                        a = 1;
                    } else {
                        a = 0
                    }
                    return '<a class="removecls" onclick="del_data(' + row.user_id + ',' + a + ')"></a>';
                }
            }, {
                field: 'user_id',
                hidden: true
            }, {
                field: 'user_phone',
                title: '账号',
                width: 80,

                align: 'center',
            }, {
                field: 'user_name',
                title: '用户名',
                width: 80,
                align: 'center',
                editor: 'text'
            }, {
                field: 'user_pwd',
                title: '密码',
                width: 150,
                align: 'center',
            }, {
                field: 'user_email',
                title: '邮箱',
                width: 100,
                align: 'center',
            }, {
                field: 'user_address',
                title: '地址',
                width: 100,
                align: 'center',
                editor: 'text'
            }, {
                field: 'register_time',
                title: '注册时间',
                width: 100,
                align: 'center',
            }, {
                field: 'status',
                title: '状态',
                width: 100,
                align: 'center',
                formatter: function (val, row, index) {
                    if (row.status == 0) {
                        return '账号已冻结';
                    } else {
                        return '正常使用中';
                    }
                }
            }
        ]]
    }).datagrid('enableCellEditing').datagrid('gotoCell', {index: 0, field: 'user_id'});
});

//搜索用户
function search_data() {
    var test = $(" input[ name='search_data' ] ").val();

    $.ajax({
        type: "POST",
        url: "UserServlet?method=queryUsers",
        cache: false,
        data: {"test": test},
        success: function (data) {
            $('#dg').datagrid({
                url: "UserServlet?method=queryUsers",
                queryParams: {test}, //获取表单参数传递
                fitColumns: true,
                rownumbers: true,
                pagination: true,
                pageSize: 10,
                pageList: [10, 20, 30],
                onAfterEdit: editRow,
                onLoadSuccess: function (data) {
                    $('.removecls').linkbutton({
                        text: '',
                        plain: true,
                        iconCls: 'icon-remove'
                    });
                },
                columns: [[
                    {
                        field: 'opt',
                        title: '操作',
                        width: 50,
                        align: 'center',
                        formatter: function (val, row, index) {
                            var a;
                            if (row.status == 0) {
                                a = 1;
                            } else {
                                a = 0
                            }
                            return '<a class="removecls" onclick="del_data(' + row.user_id + ',' + a + ')"></a>';
                        }
                    }, {
                        field: 'user_id',
                        hidden: true
                    }, {
                        field: 'user_phone',
                        title: '账号',
                        width: 80,
                        align: 'center',
                    }, {
                        field: 'user_name',
                        title: '用户名',
                        width: 80,
                        align: 'center',
                        editor: 'text'
                    }, {
                        field: 'user_pwd',
                        title: '密码',
                        width: 150,
                        align: 'center',
                    }, {
                        field: 'user_email',
                        title: '邮箱',
                        width: 80,
                        align: 'center',
                    }, {
                        field: 'user_address',
                        title: '地址',
                        width: 100,
                        align: 'center',
                        editor: 'text'
                    }, {
                        field: 'register_time',
                        title: '注册时间',
                        width: 100,
                        align: 'center',
                    }, {
                        field: 'status',
                        title: '状态',
                        width: 100,
                        align: 'center',
                        formatter: function (val, row, index) {
                            if (row.status == 0) {
                                return '账号已冻结';
                            } else {
                                return '正常使用中';
                            }
                        }
                    }
                ]]
            }).datagrid('enableCellEditing').datagrid('gotoCell', {index: 0, field: 'user_id'});
        }
    })
}

//修改用户信息
function editRow(index, row, changes) {
    $.ajax({
        type: "POST",
        url: "UserServlet?method=edit&row=[" + JSON.stringify(row) + "]",
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

//刷新
function refresh_data() {
    $('#dg').datagrid('reload');
}

//账号操作
function del_data(user_id, status) {
    $.ajax({
        type: "POST",
        url: "UserServlet?method=dele",
        data: {
            "user_id": user_id,
            "status": status
        },
        cache: false,
        success: function (data) {
            var obj = jQuery.parseJSON(data);
            alert(obj.header.message);
            $('#dg').datagrid('reload');
        },
        error: function () {
            alert("error");
        }
    });
}

