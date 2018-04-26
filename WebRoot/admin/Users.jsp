<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<jsp:include page="/base/Base.jsp"></jsp:include>
<!DOCTYPE >
<html>
<title>用户管理</title>
<head>
    <base href="${_basePath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title> Users</title>
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
<!-- 查询表单开始   -->
<form id="testForm" name="testForm">
    <div id="tb" style="padding: 2px 5px;">
        搜索内容:（仅限账号）
        <input id="search_data" name="search_data" class="easyui-textbox"
               style="width: 250px" type="number">
        <span id="tip" style="color: red;"></span>
        <a onclick="search_data()" class="easyui-linkbutton" iconCls="icon-search">Search</a>
        <a onclick="refresh_data()" class="easyui-linkbutton">Refresh</a>
        <a style="float:right;font-size: 20px">用户列表</a>
    </div>
</form>
<!-- 查询表单结束   -->
<!-- 列表展示开始   -->
<table id="dg" style="height:340px"></table>
<!-- 列表展示结束   -->

<script type="text/javascript" src="admin/js/ShowUser.js"></script>

</body>
</html>
