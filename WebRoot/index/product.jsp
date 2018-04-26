<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/base/Base.jsp"></jsp:include>

<!DOCTYPE>
<html>

<head>
    <base href="${_basePath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Product Details</title>
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
<!-- shop-area start -->
<div class="shop-area">
    <div class="container">
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-5">
                <div class="product-zoom">
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div class="tab-pane active" id="home">
                            <div class="pro-large-img">
                                <img src="${bid[0].file_path}" alt="${bid[0].book_name}"/>
                                <a class="popup-link" href='${bid[0].file_path}'>View larger <i
                                        class="fa fa-search-plus" aria-hidden="true"></i></a>
                            </div>
                        </div>
                        <div class="tab-pane" id="profile">
                            <div class="pro-large-img">
                                <img src="${bid[0].file_path}" alt="${bid[0].book_name}"/>
                                <a class="popup-link" href='${bid[0].file_path}'>View larger <i
                                        class="fa fa-search-plus" aria-hidden="true"></i></a>
                            </div>
                        </div>
                        <div class="tab-pane" id="messages">
                            <div class="pro-large-img">
                                <img src="${bid[0].file_path}" alt="${bid[0].book_name}"/>
                                <a class="popup-link" href='${bid[0].file_path}'>View larger <i
                                        class="fa fa-search-plus" aria-hidden="true"></i></a>
                            </div>
                        </div>
                        <div class="tab-pane" id="settings">
                            <div class="pro-large-img">
                                <img src="${bid[0].file_path}" alt="${bid[0].book_name}"/>
                                <a class="popup-link" href='${bid[0].file_path}'>View larger <i
                                        class="fa fa-search-plus" aria-hidden="true"></i></a>
                            </div>
                        </div>
                    </div>
                    <!-- Nav tabs -->
                    <ul class="details-tab">
                        <li class="active"><a href="#home" data-toggle="tab"><img src="${bid[0].file_path}"
                                                                                  alt="${bid[0].book_name}"/></a></li>
                        <li><a href="#profile" data-toggle="tab"><img src="${bid[0].file_path}"
                                                                      alt="${bid[0].book_name}"/></a></li>
                        <li><a href="#messages" data-toggle="tab"><img src="${bid[0].file_path}"
                                                                       alt="${bid[0].book_name}"/></a></li>
                        <li><a href="#settings" data-toggle="tab"><img src="${bid[0].file_path}"
                                                                       alt="${bid[0].book_name}"/></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-7">
                <div class="product-details">

                    <c:forEach var="b" items="${bid}">
                        <br>
                        <h2 class="pro-d-title">${b.book_name}</h2>
                        <div class="pro-ref">
                            <p>
                                <span>作者：</span>
                                <label>
                                    <a href="https://www.baidu.com/s?ie=UTF-8&wd=${b.book_author}" target="_blank">
                                            ${b.book_author}
                                    </a>
                                </label> &nbsp;&nbsp;&nbsp;&nbsp;
                                <span>译者：</span>
                                <label>
                                    <a href="https://www.baidu.com/s?ie=UTF-8&wd=${b.book_translate}" target="_blank">
                                            ${b.book_translate}
                                    </a>
                                </label> &nbsp;&nbsp;&nbsp;&nbsp;
                            </p>
                            <p>
                                <span>出版社：</span>
                                <label>
                                    <a href="http://baike.baidu.com/item/${b.book_publish}" target="_blank">
                                            ${b.book_publish}
                                    </a>
                                </label> &nbsp;&nbsp;&nbsp;&nbsp;
                                <span>出版时间：</span>
                                <label>${b.book_published_time}</label>
                            </p>
                        </div>
                        <div class="price-box">
                            <span class="price product-price">价格：${b.book_price}</span>&nbsp;&nbsp;
                            <span class="old-price product-price">${b.book_price + 5}</span>
                        </div>
                        <div class="short-desc">
                            <p>
                                描述：${b.book_description}
                            </p>
                        </div>
                        <div class="box-quantity">
                            <label>数量</label>
                            <input type="number" value="1" min="1"/>
                            <input type="hidden" id="book_id" value="${b.book_id}"/>
                            <button onclick="addCar()">加入购物车</button>
                            <button>立即购买</button>
                        </div>
                    </c:forEach>
                    <div class="usefull_link_block">
                        <ul>
                            <li><a><i class="fa fa-envelope-o"></i>Send to a friend</a></li>
                            <li><a><i class="fa fa-print"></i>Print</a></li>
                            <li><a><i class="fa fa-heart-o"></i> Add to wishlist</a></li>
                        </ul>
                    </div>
                    <div class="share-icon">
                        <a class="twitter"><i class="fa fa-facebook"></i> facebook</a>
                        <a class="facebook"><i class="fa fa-twitter"></i> twitter</a>
                        <a class="google"><i class="fa fa-google-plus"></i> linkedin</a>
                        <a class="pinterest"><i class="fa fa-pinterest"></i> facebook</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- shop-area end -->
<!-- pro-info-area start -->
<div class="pro-info-area ptb-80">
    <div class="container">
        <div class="pro-info-box">
            <!-- Nav tabs -->
            <ul class="pro-info-tab" role="tablist">
                <li class="active"><a href="#home3" data-toggle="tab">更多信息</a></li>
                <li><a href="#profile3" data-toggle="tab">其他</a></li>
                <!-- <li><a href="#messages3" data-toggle="tab">Reviews</a></li> -->
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane active" id="home3">
                    <div class="pro-desc">
                        <p>${bid[0].book_description}</p>
                    </div>
                </div>
                <div class="tab-pane" id="profile3">
                    <div class="pro-desc">
                        <table class="table-data-sheet">
                            <tbody>
                            <tr class="odd">
                                <td>Compositions</td>
                                <td>Cotton</td>
                            </tr>
                            <tr class="even">
                                <td>Styles</td>
                                <td>Casual</td>
                            </tr>
                            <tr class="odd">
                                <td>Properties</td>
                                <td>Short Sleeve</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- pro-info-area end -->

<!-- 类似书籍-->
<div class="best-sell-area">
    <div class="container">
        <div class="row">
            <div class="section-title text-center mb-50">
                <h2>类似书籍</h2>
            </div>
        </div>
        <div class="row">
            <div class="product-carousel">
                <c:forEach var="bs" items="${books}">
                    <c:if test="${bs.book_type == bid[0].book_type}">
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
                    </c:if>
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
                    <c:if test="${bs.book_type != bid[0].book_type}">
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
                    </c:if>
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
