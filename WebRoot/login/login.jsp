<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<jsp:include page="/base/Base.jsp"></jsp:include>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="${_basePath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Insert title here</title>

    <!-- CSS样式引入 -->
    <link rel="stylesheet" type="text/css" href="base/css/home.css?v=2"/>
    <link rel="stylesheet" type="text/css" href="base/css/normalize.css"/>
    <link rel="stylesheet" type="text/css" href="base/css/default.css"/>
    <link rel="stylesheet" type="text/css" href="base/css/styles.css"/>

    <!-- JavaScript插件引入 -->
    <script type="text/javascript" src="base/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="base/js/jquery.validate.js"></script>

    <!-- 验证表单信息插件载入 -->
    <script type="text/javascript">
        $(document).ready(function () {
            $("#loginForm").validate();
            $("#registerForm").validate();
        });
    </script>

</head>

<body>

<div class="wrap">
    <!-- 图片轮播样式 -->
    <div class="banner-show" id="js_ban_content">
        <div class="cell bns-01">
            <div class="con"></div>
        </div>
        <div class="cell bns-02" style="display:none;">
            <div class="con"></div>
        </div>
        <div class="cell bns-03" style="display:none;">
            <div class="con"></div>
        </div>
    </div>

    <div class="banner-control" id="js_ban_button_box">
        <a href="javascript:;" class="left">左</a> <a href="javascript:;" class="right">右</a>
    </div>

    <!--  图片轮播js开始  -->
    <script type="text/javascript">
        ;(function () {
            var defaultInd = 0;
            var list = $('#js_ban_content').children();
            var count = 0;
            var change = function (newInd, callback) {
                if (count) return;
                count = 2;
                $(list[defaultInd]).fadeOut(400, function () {
                    count--;
                    if (count <= 0) {
                        if (start.timer) window.clearTimeout(start.timer);
                        callback && callback();
                    }
                });
                $(list[newInd]).fadeIn(400, function () {
                    defaultInd = newInd;
                    count--;
                    if (count <= 0) {
                        if (start.timer) window.clearTimeout(start.timer);
                        callback && callback();
                    }
                });
            }

            var next = function (callback) {
                var newInd = defaultInd + 1;
                if (newInd >= list.length) {
                    newInd = 0;
                }
                change(newInd, callback);
            }

            var start = function () {
                if (start.timer) window.clearTimeout(start.timer);
                start.timer = window.setTimeout(function () {
                    next(function () {
                        start();
                    });
                }, 8000);
            }

            start();

            $('#js_ban_button_box').on('click', 'a', function () {
                var btn = $(this);
                if (btn.hasClass('right')) {
                    //next
                    next(function () {
                        start();
                    });
                } else {
                    //prev
                    var newInd = defaultInd - 1;
                    if (newInd < 0) {
                        newInd = list.length - 1;
                    }
                    change(newInd, function () {
                        start();
                    });
                }
                return false;
            });
        })();
    </script>
    <!-- 图片轮播结束 -->

    <!-- 内容开始 -->
    <div class="htmleaf-container">
        <div class="login-wrap">
            <div class="login-html">
                <input id="tab-1" type="radio" name="tab" class="sign-in" checked>
                <label for="tab-1" class="tab">Log In</label>
                <input id="tab-2" type="radio" name="tab" class="sign-up">
                <label for="tab-2" class="tab">Sign Up</label>

                <div class="login-form">
                    <!-- 登录表单 -->
                    <form id="loginForm" name="loginForm" method="post"
                          action="UserServlet?method=login">
                        <div class="sign-in-htm">
                            <div class="group">
                                <input id="user_phone" name="user_phone" type="text"
                                       class="input required" placeholder="手机账号">
                            </div>
                            <div class="group">
                                <input id="user_pwd" name="user_pwd" type="password"
                                       class="input required" placeholder="密码">
                            </div>
                            <div class="group">
                                <input id="check" type="checkbox" class="check" checked>
                                <label for="check"><span class="icon">
										</span> Keep me Log in</label>
                            </div>
                            <div class="group">
                                <input type="submit" class="button submit" value="Log In">
                            </div>
                        </div>
                    </form>
                    <!-- 表单结束 -->

                    <!-- 注册表单 -->
                    <form id="registerForm" name="registerForm" method="post"
                          action="UserServlet?method=register">
                        <div class="sign-up-htm">
                            <div class="group">
                                <input id="user_phone" name="user_phone" type="text"
                                       class="input required" placeholder="手机号码"
                                       onblur="isExist(this.value)">
                                <label id="user_phone_tip" for="user_phone_tip" class="label"></label>
                            </div>
                            <div class="group">
                                <input id="user_name" name="user_name" type="text"
                                       class="input required" placeholder="用户名">
                            </div>
                            <div class="group">
                                <input id="user_pwd" name="user_pwd" type="password"
                                       class="input required" data-type="password" placeholder="密码">
                            </div>
                            <div class="group">
                                <input id="user_email" name="user_email" type="text"
                                       class="input required email" placeholder="邮箱">
                            </div>
                            <div class="group">
                                <input type="submit" class="button submit" value="Sign Up">
                            </div>
                        </div>
                    </form>
                    <!-- 表单结束 -->

                </div>
            </div>
        </div>
    </div>
    <!-- 内容结束 -->
</div>

<!-- ajax验证 -->
<script type="text/javascript" src="login/js/check_phone.js"></script>

</body>
</html>