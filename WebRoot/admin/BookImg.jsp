<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<jsp:include page="/base/Base.jsp"></jsp:include>
<!DOCTYPE >
<html>
<title>用户管理</title>
<head>
    <base href="${_basePath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Book Images</title>
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
<!-- 列表展示开始   -->
<table id="dg"></table>
<!-- 列表展示结束   -->

<script type="text/javascript" src="admin/js/ShowBookImg.js"></script>

</body>
</html>
