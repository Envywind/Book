<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<jsp:include page="/base/Base.jsp"></jsp:include>

<!DOCTYPE >
<html>
<title>用户管理</title>
<head>
    <base href="${_basePath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Book </title>
    <!-- CSS样式引入 -->
    <link rel="stylesheet" type="text/css" href="base/easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="base/easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="base/easyui-1.5/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="base/css/style.css">
    <!-- JS引入 -->
    <script type="text/javascript" src="base/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="base/easyui-1.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="base/easyui-1.5/datagrid-cellediting.js"></script>
</head>
<body>
<form id="testForm" name="testForm">
    <div id="tb" style="padding: 2px 5px;">
        <a onclick="add_data();" class="easyui-linkbutton" iconCls="icon-add"
           plain="true">添加</a>
    </div>
</form>
<!-- 查询表单结束   -->
<!-- 列表展示开始   -->
<table id="dg"></table>

<!-- 添加窗口开始   -->
<div id="dialog_add_edit" style="display: none;">
    <form name="addEditForm" id="addEditForm" method="post" enctype="multipart/form-data">

        <input type="hidden" name="add_id" id="add_id">

        <table align="center">
            <tr class="formRow">
                <td class="formLabel">书名：</td>
                <td class="formField">
                    <input type="text" name="book_name"
                           style="width: 220px;" class="orShortInput easyui-validatebox"
                           data-options="required:true">
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr class="formRow">
                <td class="formLabel">作者：</td>
                <td class="formField">
                    <input type="text" name="book_author"
                           style="width: 220px;" class="orShortInput easyui-validatebox"
                           data-options="required:true">
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr class="formRow">
                <td class="formLabel">译者：</td>
                <td class="formField">
                    <input type="text" name="book_translate"
                           style="width: 220px;" class="orShortInput easyui-validatebox"
                           data-options="required:true">
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr class="formRow">
                <td class="formLabel">出版社：</td>
                <td class="formField">
                    <input type="text" name="book_publish"
                           style="width: 220px;" class="orShortInput easyui-validatebox"
                           data-options="required:true">
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr class="formRow">
                <td class="formLabel">出版时间：</td>
                <td class="formField">
                    <input type="month" name="book_published_time"
                           style="width: 220px;" class="orShortInput easyui-validatebox"
                           data-options="required:true">
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr class="formRow">
                <td class="formLabel">单价：</td>
                <td class="formField">
                    <input type="price" name="book_price"
                           style="width: 220px;" class="orShortInput easyui-validatebox"
                           data-options="required:true">
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr class="formRow">
                <td class="formLabel">类型：</td>
                <td class="formField">
                    <select name="book_type">
                        <option value="Literature">青春文学</option>
                        <option value="Novel">小说</option>
                        <option value="Comic">动漫</option>
                        <option value="Children">儿童读物</option>
                        <option value="Art">艺术</option>
                        <option value="Science">科普读物</option>
                        <option value="Cook">烹饪美食</option>
                        <option value="Economic">经管励志</option>
                        <option value="History">历史</option>
                        <option value="Travel">旅游</option>
                    </select>
                    <font style="color: red">*</font>
                </td>
            </tr>
            <tr class="formRow">
                <td class="formLabel">描述：</td>
                <td class="formField">
                    <input type="text" name="book_description" style="width: 220px;height:70px"
                           class="orShortInput easyui-validatebox"
                           data-options="required:true">
                    <font style="color: red">*</font>
                </td>
            </tr>
        </table>
    </form>
</div>
<!-- 添加窗口结束   -->

<script type="text/javascript" src="admin/js/ShowBook.js"></script>


</body>
</html>
