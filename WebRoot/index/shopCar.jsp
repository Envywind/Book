<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/base/Base.jsp"></jsp:include>

<!DOCTYPE>
<html>

<head>
    <base href="${_basePath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Shop Car</title>
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
    <link rel="stylesheet" href="base/css/css/responsive.css">
    <link rel="stylesheet" href="base/css/css/style2.css">
    <link rel="stylesheet" href="base/css/css/custom.css">
    <script src="base/js/js/vendor/modernizr-2.8.3.min.js"></script>
</head>
<body>
<!-- 头部文件引入 -->
<jsp:include page="header.jsp"></jsp:include>

<h3 align="center"><br>购物车<br><br></h3>

<table class="shop table table-striped ">
    <tbody>
    <tr>
        <td class="text-left"></td>
        <td class="text-center" style="width: 110px">商品信息</td>
        <td class="text-center"></td>
        <td class="text-center"></td>
        <td class="text-center">数量</td>
        <td class="text-center">单价</td>
        <td class="text-center" width="10%">小计</td>
        <td class="text-center">操作</td>
    </tr>

    <c:forEach var="c" items="${car}">
        <tr class="one-goods">
            <td style="text-align: center;">
                <label> <input type="checkbox" style="margin-top: 35px; margin-bottom: 25px;"
                               class="goods-check GoodsCheck" id="dd"> </label>
            </td>
            <td class="text-center" style="width: 110px">
                <a href="product.jsp"><img src='${c.file_path}'
                                           style="width: auto; height: auto;" alt="Filet Mign"
                                           title="Filet Mign" class="preview"> </a>
            </td>
            <td class="text-center">
                <input type="hidden" id="c_id" value="${c.c_id}">
                <input type="hidden" id="user_id" value="${user.user_id}">
                <input type="hidden" id="book_id" value="${c.book_id}">
            </td>
            <td class="text-center">
                <a class="cart_product_name" href="product.jsp">
                    <p style="margin-top: 35px;">
                            ${c.book_name}
                    </p>
                </a>
            </td>
            <td class="text-center">
                <button type="button" class="minus">-</button>
                <input type="text" class="am-num-text"
                       value='${c.num}'
                       style="width: 20px; height: 15px; margin-top: 35px;"/>
                <button type="button" class="plus">+</button>
            </td>
            <td class="text-center">
                <p style="margin-top: 35px;">
                    <span class="shop-total-amount GoodsPrice">${c.book_price}</span>元
                </p>
            </td>
            <td class="text-center" width="10%">
                <p style="margin-top: 35px;">
                    <span class="shop-total-amount ShopTotal">${c.total_sum}</span>元
                </p>
            </td>
            <td class="text-center">
                <a onclick="remove();" class="fa fa-times fa-delete" style="margin-top: 35px;"></a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td class="all-total text-left">
            <label>
                <input type="checkbox" class="goods-check" id="AllCheck">全选
            </label>
        </td>
        <td class="text-center" style="width: 70px"></td>
        <td class="text-center"></td>
        <td class="text-center"></td>
        <td class="text-center"></td>
        <td class="text-center"></td>
        <td class="text-center"></td>
        <td class="text-right">

            <h3>总价合计：
                <span class="shop-total-amount" id="AllTotal" name="total">0</span>元</h3>
        </td>
    </tr>
    </tbody>
</table>
<p class="text-right">
    <a class="btn btn-mega checkout-cart" href="404.jsp">
        <i class="fa fa-share"></i>立即下单</a>
</p>

<jsp:include page="footer.jsp"></jsp:include>

<!--==============JS引入====================-->
<script src="base/js/jquery.min.js"></script>
<script type="text/javascript" src="index/js/search_book.js"></script>
<script type="text/javascript" src="index/js/shopcar.js"></script>
</body>

</html>
