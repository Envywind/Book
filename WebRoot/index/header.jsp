<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE >
<html>
<body>
<header class="header-section header-section-1 container-fluid no-padding">
    <div class="top-header top-header1 container-fluid no-padding">
        <!-- Container -->
        <div class="container">
            <div class="col-md-7 col-sm-7 col-xs-7 dropdown-bar">
                <h5>Welcome To Book Shop</h5>

                <!-- 判断是否登录 -->
                <c:if test="${!empty user}">
                    <div class="language-dropdown dropdown">
                        <button aria-expanded="true" aria-haspopup="true"
                                data-toggle="dropdown" title="我的信息" id="language" type="button"
                                class="btn dropdown-toggle">${user.user_name}
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu no-padding">
                            <li><a title="修改个人信息" href="index/userinfo.jsp">修改个人信息</a></li>
                            <li><a title="我的订单" href="404.jsp">我的订单</a></li>
                            <li><a title="退出" href="UserServlet?method=quit">退出</a></li>
                        </ul>
                    </div>
                </c:if>
                <c:if test="${empty user}">　　　　　
                    <a href="login/login.jsp">点击这里登录</a>
                </c:if>
            </div>
            <!-- Social -->
            <div class="col-md-5 col-sm-5 col-xs-5 header-social">
                <ul>
                    <li><a title="Facebook"><i
                            class="fa fa-facebook"></i></a></li>
                    <li><a title="Twitter"><i class="fa fa-twitter"></i></a></li>
                    <li><a title="Linkedin"><i
                            class="fa fa-linkedin"></i></a></li>
                    <li><a title="Tumblr"><i class="fa fa-tumblr"></i></a></li>
                    <li><a title="Vimeo"><i class="fa fa-vimeo"></i></a></li>
                    <li><a title="Pinterest"><i
                            class="fa fa-pinterest-p"></i></a></li>
                </ul>
            </div>
            <!-- Social /- -->
        </div>
        <!-- Container /- -->
    </div>
    　　　
    <div class="middel-header">
        <!-- Container -->
        <div class="container">
            <!-- Logo Block -->
            <div class="col-md-4 col-sm-6 col-xs-12 logo-block">
                <a href="index/index.jsp" class="navbar-brand">book <span>shop</span></a>
            </div>
            <!-- Logo Block /- -->
            <!-- Search Block -->
            <form id="searchForm" name="searchForm" method="post">
                <div class="col-md-5 col-sm-6 col-xs-6 search-block">
                    <div class="input-group">
                        <input class="form-control" placeholder="Search You Wants Here . . ."
                               type="text" id="book_name" name="book_name" onkeydown="KeyDown()">
                        <span class="input-group-btn">
							<button class="btn btn-default" type="button" onclick="search_book()">
								<i class="icon icon-Search"></i>
							</button>
						</span>
                    </div>
                </div>
            </form>
            <!-- Search Block /- -->
            <!-- Menu Icon -->
            <div class="col-md-3 col-sm-6 col-xs-6 menu-icon">
                <ul class="cart">
                    <li><a href="CarServlet?method=showCar" title="购物车"><i class="icon icon-ShoppingCart"></i></a><i
                            class="icon icon-ShoppingCart"></i></li>
                </ul>
            </div>
            <!-- Menu Icon /- -->
        </div>
        <!-- Container /- -->
    </div>
    <div class="container-fluid no-padding menu-block">
        <div class="container">
            <nav class="navbar navbar-default ow-navigation">
                <div class="navbar-collapse collapse" id="navbar"></div>
            </nav>
        </div>
    </div>
</header>
</body>
</html>