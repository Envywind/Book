<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/base/Base.jsp"></jsp:include>

<!DOCTYPE >
<html>
<head>
    <base href="${_basePath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>User Information</title>
    <!--==============CSS样式引入====================-->
    <link rel="icon" type="image/x-icon" href="images//favicon.ico"/>
    <link rel="stylesheet" type="text/css" href="base/revolution/css/settings.css">
    <link rel="stylesheet" type="text/css" href="base/revolution/css/layers.css">
    <link rel="stylesheet" type="text/css" href="base/revolution/css/navigation.css">
    <link rel="stylesheet" type="text/css" href="base/libraries/lib.css">
    <link rel="stylesheet" type="text/css" href="base/css/plugins.css">
    <link rel="stylesheet" type="text/css" href="base/css/navigation-menu.css">
    <link rel="stylesheet" type="text/css" href="base/css/shortcode.css">
    <link rel="stylesheet" type="text/css" href="base/css/style.css">
    <!--==============JS引入====================-->
    <script type="text/javascript" src="base/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="base/js/jquery.validate.js"></script>
    <!-- 验证表单信息插件载入 -->
    <script type="text/javascript">
        $(document).ready(function () {
            $("#userForm").validate();
        });
    </script>
</head>

<body data-offset="200" data-spy="scroll" data-target=".ow-navigation">
<!-- 头部文件引入 -->
<jsp:include page="header.jsp"></jsp:include>

<div class="row">
    <div class="section-title text-center mb-50">
        <h3>个人信息</h3>
    </div>
</div>
<div class="modal-body" style="width: 95%; align: center;">
    <form id="userForm" name="userForm" method="post" action="UserServlet?method=editYourself">
        <table class="table table-striped" style="font-size: 20px; text-align: center">
            <tr>
                <td align="center">账号:</td>
                <td><input id="user_phone" name="user_phone" type="text"
                           class="form-control" size="60" readonly
                           value="${user.user_phone} "/>
                </td>
            </tr>
            <tr>
                <td align="center">用户名:</td>
                <td><input id="user_name" name="user_name" type="text"
                           class="form-control required" size="60"
                           value="${user.user_name}"/>
                </td>
            </tr>
            <tr>
                <td align="center">密码:</td>
                <td><input id="user_pwd" name="user_pwd" type="password"
                           class="form-control required" size="60"
                           placeholder="密码已隐藏、请再次输入您的密码"/>
                </td>
            </tr>
            <tr>
                <td align="center">邮箱:</td>
                <td><input id="user_email" name="user_email" type="text"
                           class="form-control required email" size="60"
                           value="${user.user_email}"/>
                </td>
            </tr>
            <tr>
                <td align="center">地址:</td>
                <td><input id="user_address" name="user_address" type="text"
                           class="form-control required " size="60"
                           value="${user.user_address}"/>
                </td>
            </tr>
        </table>
        <div align="right">
            <input type="hidden" id="user_id" name="user_id" value="${user.user_id}"/>
            <input type="reset" class="btn btn-faile" value="重置"/>&nbsp;&nbsp;&nbsp;
            <input type="submit" class="btn btn-success" value="确认修改"/>
        </div>
    </form>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<script src="index/js/search_book.js"></script>
</body>
</html>
