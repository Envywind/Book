$(function () {
    // 数量减
    $(".minus").click(function () {
        var t = $(this).parent().find('.am-num-text');
        t.val(parseInt(t.val()) - 1);
        if (t.val() <= 1 || t.val() == "") {
            t.val(1);
        }
        TotalPrice();
    }); // 数量加
    $(".plus").click(function () {
        var t = $(this).parent().find('.am-num-text');
        t.val(parseInt(t.val()) + 1);
        TotalPrice();
    }); // 点击商品按钮
    $(".GoodsCheck").click(function () {
        var goods = $(this).closest(".shop").find(".GoodsCheck"); // 获取本店铺的所有商品
        var goodsC = $(this).closest(".shop").find(".GoodsCheck:checked"); // 获取本店铺所有被选中的商品
        if (goods.length == goodsC.length) { // 如果选中的商品等于所有商品
            $("#AllCheck").prop('checked', true); // 全选按钮被选中
            TotalPrice();
        } else if (goodsC.length == 0) {
            $("#AllCheck").prop('checked', false);
            var allprice = 0;
            $("#AllTotal").text(allprice.toFixed(2));
        } else {
            $("#AllCheck").prop('checked', false); // else全选按钮不被选中
            TotalPrice();
        }
    }); // 点击店铺按钮

    $("#AllCheck").click(function () {
        if ($(this).prop("checked") == true) { // 如果全选按钮被选中
            $(".goods-check").prop('checked', true); // 所有按钮都被选中
            TotalPrice();
        } else {
            $(".goods-check").prop('checked', false); // else所有按钮不全选
            var allprice = 0;
            $("#AllTotal").text(allprice.toFixed(2));
        }

    });
})

function TotalPrice() {
    var allprice = 0; // 总价
    $(".one-goods").each(function () { // 循环每个店铺
        var oprice = 0; // 店铺总价
        $(this).find(".GoodsCheck").each(function () { // 循环店铺里面的商品
            var num = parseInt($(this).parents(".one-goods").find(".am-num-text").val()); // 得到商品的数量
            var price = parseFloat($(this).parents(".one-goods").find(".GoodsPrice").text()); // 得到商品的单价
            var total = price * num; // 计算单个商品的总价
            oprice += total; // 计算该店铺的总价
            $(this).closest(".one-goods").find(".ShopTotal").text(oprice.toFixed(2)); // 显示被选中商品的店铺总价
        });
        // 如果该商品被选中
        if ($(this).find(".GoodsCheck").is(":checked")) {
            var oneprice = parseFloat($(this).find(".ShopTotal").text()); // 得到每个店铺的总价
            allprice += oneprice; // 计算所有店铺的总价
        }
    });
    if ($(".GoodsCheck").is(":checked")) {
        $("#AllTotal").text(allprice.toFixed(2)); // 输出全部总价
    }
}

function remove() {

    var c_id = $('#c_id').val();
    // 请求处理
    $.ajax({
        // 提交的网址
        url: "CarServlet?mrthod=dele",
        // 不缓存数据
        cache: false,
        // 提交的数据
        data: {"c_id": c_id},
        // 成功返回之后调用的函数
        success: function (data) {
            location.reload();
        },
        // 调用出错执行的函数
        error: function () {
            alert("操作失败");
        }
    });
}

function order() {
    var user_id = $('#user_id').val();
    var c_id;
    var quantiy;
    var unitcost;
    var total;
    var status = 0;
    var alltotal = 0;

    $(".one-goods").each(function () { // 循环每个店铺
        // 如果该商品被选中
        if ($(this).find(".GoodsCheck").is(":checked")) {
            c_id = $(this).find("#c_id").val();           //c_id
            quantiy = $(this).find(".am-num-text").val();  //数量
            unitcost = $(this).find(".GoodsPrice").text(); //单价
            total = $(this).find(".ShopTotal").text();     //一件的总价
            alltotal = $("#AllTotal").text();              //所有商品的总价

            // 请求处理
            $.ajax({
                // 提交的网址
                url: "CarServlet?method=order",
                // 不缓存数据
                cache: false,
                // 提交的数据
                data: {
                    "user_id": user_id,
                    "c_id": c_id,
                    "quantiy": quantiy,
                    "unitcost": unitcost,
                    "total": total,
                    "status": status,
                    "alltotal": alltotal
                },
                // 成功返回之后调用的函数
                success: function (data) {
                }
            });
            status = status + 1;
        }
    });
    if ($(".GoodsCheck").is(":checked")) {
        $("#AllTotal").text(allprice.toFixed(2)); // 输出全部总价
    }
}