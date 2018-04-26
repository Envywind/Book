package book.service.bookinfo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.core.servlet.BaseServlet;
import book.core.utils.Header;
import book.core.utils.JsonObject;

import book.service.bookinfo.dao.BookDao;
import book.service.bookinfo.impl.BookImpl;
import book.service.bookinfo.pojo.Book;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BookServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;
    private BookDao dao = new BookImpl();

    /**
     * 主页展示所有书籍
     */
    public void queryAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = dao.queryAll();
        request.getSession().setAttribute("books", books);
        response.sendRedirect("index/index.jsp");
    }

    /**
     * 书籍详情页面
     */
    public void queryByID(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);//防止创建Session
        session.removeAttribute("bid");

        String id = request.getParameter("ID");
        List<Book> bid = dao.queryByID(id);

        request.getSession().setAttribute("bid", bid);
        response.sendRedirect("index/product.jsp");

    }

    /**
     * 书籍搜索
     */
    public void queryByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);//防止创建Session
        session.removeAttribute("bname");

        String book_name = request.getParameter("book_name");
        List<Book> bname = dao.queryByName(book_name);
        if (bname != null && !bname.isEmpty()) {
            session.setAttribute("bname", bname);
        }
    }

    /**
     * 管理模块展示书籍
     */
    public void queryBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tableName = request.getParameter("tableName");
        String pageNumber = request.getParameter("page");
        String pageSize = request.getParameter("rows");

        BookDao dao = new BookImpl();

        List<Book> list = dao.queryBook(pageNumber, pageSize);

        JSONArray json = JSONArray.fromObject(list);

        JSONObject object = new JSONObject();
        object.put("total", dao.queryCount(tableName).getCount());
        object.put("rows", json);

        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter pw = response.getWriter();
        pw.write(object.toString());
    }

    /**
     * 管理模块展示书籍图片
     */
    public void queryImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String tableName = request.getParameter("tableName");
        String pageNumber = request.getParameter("page");
        String pageSize = request.getParameter("rows");

        BookDao dao = new BookImpl();

        List<Book> list = dao.queryImg(pageNumber, pageSize);

        JSONArray json = JSONArray.fromObject(list);

        JSONObject object = new JSONObject();
        object.put("total", dao.queryCount(tableName).getCount());
        object.put("rows", json);

        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter pw = response.getWriter();
        pw.write(object.toString());
    }

    /**
     * 管理模块书籍上架
     */
    public void addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String book_name = request.getParameter("book_name");
        String book_type = request.getParameter("book_type");
        String book_price = request.getParameter("book_price");
        String book_author = request.getParameter("book_author");
        String book_publish = request.getParameter("book_publish");
        String book_translate = request.getParameter("book_translate");
        String book_description = request.getParameter("book_description");
        String book_published_time = request.getParameter("book_published_time");

        int rs = dao.addBook(book_name, book_type, book_price, book_author,
                book_publish, book_translate, book_description, book_published_time);
        if (rs > 0) {
            this.outWirte(new JsonObject(new Header(1, "请继续选择图片！", false), null), response);
        } else {
            this.outWirte(new JsonObject(new Header(10003, "操作失败！", false), null), response);
        }

    }

    /**
     * 管理模块书籍编辑
     */
    public void editBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String row = request.getParameter("row");

        JSONArray array = JSONArray.fromObject(row);
        Object[] obj = array.toArray();
        JSONObject object = JSONObject.fromObject(obj[0]);

        Book book = (Book) JSONObject.toBean(object, Book.class);

        int rs = dao.editBook(book.getBook_id(), book.getBook_name(), book.getBook_type(),
                book.getBook_price(), book.getBook_author(), book.getBook_publish(),
                book.getBook_translate(), book.getBook_description(), book.getBook_published_time());
        if (rs > 0) {
            this.outWirte(new JsonObject(new Header(1, "修改成功！", false), null), response);
        } else {
            this.outWirte(new JsonObject(new Header(10003, "操作失败！", false), null), response);
        }

    }


}
