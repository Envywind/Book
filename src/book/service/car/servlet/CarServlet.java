package book.service.car.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.core.servlet.BaseServlet;

import book.core.utils.Header;
import book.core.utils.JsonObject;

import book.service.car.dao.CarDao;
import book.service.car.impl.CarImpl;
import book.service.car.pojo.Car;
import book.service.users.pojo.User;

public class CarServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;
    private CarDao dao = new CarImpl();

    /**
     * 添加到购物车
     */
    public void addCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        int user_id = user.getUser_id();
        String id = request.getParameter("ID");

        List<Car> bid = dao.queryPrice(id);
        String book_price = bid.iterator().next().getBook_price();

        int rs = dao.addCar(user_id, id, book_price);

        if (rs > 0) {
            this.outWirte(new JsonObject(new Header(1, "已加入购物车！", false), null), response);
        } else {
            this.outWirte(new JsonObject(new Header(1, "添加失败！", false), null), response);
        }
    }

    /**
     * 查看购物车
     */
    public void showCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        session.removeAttribute("car");

        User user = (User) request.getSession().getAttribute("user");
        int user_id = user.getUser_id();
        List<Car> car = dao.queryCar(user_id);
        request.getSession().setAttribute("car", car);
        response.sendRedirect("index/shopCar.jsp");
    }

    /**
     * 购物车删除商品
     */
    public void dele(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String c_id = request.getParameter("c_id");
        int rs = dao.dele(c_id);
        if (rs > 0) {
            this.outWirte(new JsonObject(new Header(1, "删除成功！", false), null), response);
        } else {
            this.outWirte(new JsonObject(new Header(1, "删除失败！", false), null), response);
        }
    }
}
