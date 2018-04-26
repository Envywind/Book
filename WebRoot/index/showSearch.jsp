<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/base/Base.jsp"></jsp:include>

<!DOCTYPE >
<html>

<head>
    <base href="${_basePath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Search data</title>
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

    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <link rel="stylesheet" href="base/css/css/bootstrap.min.css">
    <link rel="stylesheet" href="base/css/css/core.css">
    <link rel="stylesheet" href="base/css/css/shortcode/shortcodes.css">
    <link rel="stylesheet" href="base/css/css/style2.css">
    <link rel="stylesheet" href="base/css/css/responsive.css">
    <link rel="stylesheet" href="base/css/css/custom.css">
    <script src="base/js/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body data-offset="200" data-spy="scroll" data-target=".ow-navigation">
<!-- 头部文件引入 -->
<jsp:include page="header.jsp"></jsp:include>
<br><br>
<div class="best-sell-area">
    <div class="container">
        <div class="row">
            <div class="section-title text-center mb-50">
                <h2>搜索结果</h2>
                <c:if test="${empty bname}">
                    <h3 align="center"><br><br>暂无相关书籍<br><br></h3>
                </c:if>
            </div>
        </div>
        <div class="row">
            <div class="product-carousel">
                <c:forEach var="bs" items="${bname}">
                    <div class="col-md-12">
                        <div class="product-wrapper mb-40 mrg-nn-xs">
                            <div class="product-img">
                                <a href='BookServlet?method=queryByID&&ID=${bs.book_id}' target="_blank">
                                    <img src="${bs.file_path}" alt="${bs.book_name}"/>
                                </a>
                                <div class="product-action">
                                    <input type="hidden" id="book_id" value="${bs.book_id}"/>
                                    <a onclick='addCar()'>Cart</a>
                                </div>
                            </div>
                            <div class="product-content" align="center">
                                <div class="pro-title">
                                    <h3>
                                        <a href='BookServlet?method=queryByID&&ID=${bs.book_id}' target="_blank">
                                                ${bs.book_name}
                                        </a>
                                    </h3>
                                    <span class="price">
										${bs.book_price}
										<span class="old-price">${bs.book_price+5.00}</span>
									</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-o"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            </div>
        </div>
    </div>
</div>
<!-- 类似书籍/ -->
<!-- 其他书籍 -->
<div class="best-sell-area ptb-60">
    <div class="container">
        <div class="row">
            <div class="section-title text-center mb-50">
                <h2>其他书籍</h2>
            </div>
        </div>
        <div class="row">
            <div class="product-carousel">
                <c:forEach var="bs" items="${books}">
                    <div class="col-md-12">
                        <div class="product-wrapper mb-40 mrg-nn-xs">
                            <div class="product-img">
                                <a href='BookServlet?method=queryByID&&ID=${bs.book_id}' target="_blank">
                                    <img src="${bs.file_path}" alt="${bs.book_name}"/>
                                </a>
                                <span class="new-label">New</span>
                                <div class="product-action">
                                    <input type="hidden" id="book_id" value="${bs.book_id}"/>
                                    <a onclick='addCar()'>Cart</a>
                                </div>
                            </div>
                            <div class="product-content" align="center">
                                <div class="pro-title">
                                    <h3>
                                        <a href='BookServlet?method=queryByID&&ID=${bs.book_id}' target="_blank">
                                                ${bs.book_name}
                                        </a>
                                    </h3>
                                    <span class="price">
										${bs.book_price}
										<span class="old-price">${bs.book_price+5.00}</span>
									</span>&nbsp;&nbsp;&nbsp;&nbsp;
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star"></i>
                                    <i class="fa fa-star-o"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
<!-- 其他书籍/ -->

<jsp:include page="footer.jsp"></jsp:include>

<!--==============JS引入====================-->
<script src="base/js/jquery.min.js"></script>
<script type="text/javascript" src="index/js/search_book.js"></script>
<script type="text/javascript" src="index/js/addCar.js"></script>

<script src="base/js/js/bootstrap.min.js"></script>
<script src="base/js/js/ajax-mail.js"></script>
<script src="base/js/js/owl.carousel.min.js"></script>
<script src="base/js/js/jquery-ui.min.js"></script>
<script src="base/js/js/jquery.nivo.slider.pack.js"></script>
<script src="base/js/js/plugins.js"></script>
<script src="base/js/js/main.js"></script>

<script src="base/libraries/lib.js"></script>
<script src="base/libraries/jquery.countdown.min.js"></script>
<script src="base/revolution/js/jquery.themepunch.tools.min.js?rev=5.0"></script>
<script src="base/revolution/js/jquery.themepunch.revolution.min.js?rev=5.0"></script>
<script src="base/revolution/js/extensions/revolution.extension.video.min.js"></script>
<script src="base/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
<script src="base/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
<script src="base/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
<script src="base/revolution/js/extensions/revolution.extension.actions.min.js"></script>
<script src="base/js/functions.js"></script>
</body>

</html>
