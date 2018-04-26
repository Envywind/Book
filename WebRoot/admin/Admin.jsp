<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/base/Base.jsp"></jsp:include>

<!DOCTYPE >
<html>
<head>
    <base href="${_basePath}"/>
    <c:if test="${empty user}">
        <script>alert("权限不足，返回登录页面！");
        location.href = "login/login.jsp"</script>
    </c:if>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Admin</title>
    <!-- CSS样式引入 -->
    <link rel="stylesheet" type="text/css" href="base/easyui-1.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="base/easyui-1.5/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="base/easyui-1.5/demo/demo.css">
    <link rel="stylesheet" type="text/css" href="base/css/style.css">
    <style type="text/css">
        a {
            color: Black;
            text-decoration: none;
            cursor: pointer;
        }

        a:hover {
            color: Red;
            text-decoration: underline;
        }

        .easyui-accordion ul {
            list-style-type: none;
            margin: 0px;
            padding: 10px;
            font-family: 'Lato', sans-serif;
        }

        .easyui-accordion ul li {
            padding: 0px;
            cursor: pointer;
        }
    </style>
    <!-- JS引入 -->
    <script type="text/javascript" src="base/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="base/easyui-1.5/jquery.easyui.min.js"></script>
    <script type="text/javascript">
        /* 添加选项卡方法 */
        function addTab(title, url) {
            //先判断是否存在标题为title的选项卡
            var tab = $('#easytabs').tabs('exists', title);
            if (tab) {
                //若存在，则直接打开
                $('#easytabs').tabs('select', title);
            } else {
                //否则创建
                $('#easytabs').tabs('add', {
                    title: title,
                    content: "<iframe width='100%' height='100%'  id='iframe' frameborder='0' scrolling='auto'  src='" + url + "'></iframe>",
                    closable: true
                });
            }
        }
    </script>
</head>

<body class="easyui-layout">
<!-- TOP开始   -->
<div data-options="region:'north',border:false">
    <!-- Header -->
    <header class="header-section header-section-1 container-fluid no-padding">
        <!-- Top Header -->
        <div class="top-header top-header1 container-fluid no-padding">
            <!-- Container -->
            <div class="container">
                <div class="col-md-7 col-sm-7 col-xs-7 dropdown-bar" style="font-size: 30px">
                    <h5>
                        Welcome To Book Shop --------管理员：
                        <a title="退出" href="UserServlet?method=quit">
                            ${user.user_name}</a>
                    </h5>
                    <br>

                </div>
            </div><!-- Container /- -->
        </div><!-- Top Header /- -->
    </header><!-- Header /- -->
</div>
<!-- TOP结束   -->

<div data-options="region:'center'" style="border: 0px;">
    <div class="easyui-layout" data-options="fit:true" style="border: 0px;">

        <!-- 菜单栏开始（动态加载）   -->
        <div data-options="region:'west',split:true,title:'后台管理模块'"
             style="width: 180px; height: 100%; overflow: hidden; overflow-x: hidden;">
            <div class="easyui-accordion" fit="true">
                <div title="系统管理">
                    <ul>
                        <li onclick="javascript:addTab('用户信息管理','admin/Users.jsp');">用户信息管理</li>
                    </ul>
                    <ul>
                        <li onclick="javascript:addTab('书籍信息管理','admin/Book.jsp');">书籍信息管理</li>
                    </ul>
                    <ul>
                        <li onclick="javascript:addTab('书籍图片信息管理','admin/BookImg.jsp');">书籍图片信息管理</li>
                    </ul>
                    <ul>
                        <li onclick="javascript:addTab('上传书籍图片','admin/addBookImg.jsp');">上传书籍图片</li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- 菜单栏结束   -->

        <!-- 首页开始   -->
        <div data-options="region:'center'">
            <div id="easytabs" class="easyui-tabs" fit="true">
                <div title="首页"><img width=100% height=100% alt="" src="base/images/mid_banner/3.jpg">
                    <iframe frameborder="0" src=""
                            style="width:100%;height:483px;overflow:-Scroll;overflow-y:hidden;"></iframe>
                </div>
            </div>
        </div>
        <!-- 首页结束   -->
    </div>
</div>
</body>
</html>
	

