package book.service.users.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.core.servlet.BaseServlet;
import book.core.utils.Header;
import book.core.utils.JsonObject;
import book.service.users.dao.UserDao;
import book.service.users.impl.UserImpl;
import book.service.users.pojo.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    private UserDao dao = new UserImpl();

    /**
     * 登录
     * user_phone：admin   为管理员身份
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String user_phone = request.getParameter("user_phone");
        String user_pwd = request.getParameter("user_pwd");

        User user = dao.login(user_phone, user_pwd);

        if (user != null) {
            request.getSession().setAttribute("user", user);

            if (user_phone.equals("admin")) {
                out.print("<script>alert('进入管理员模块！');location.href='admin/Admin.jsp'</script>");
            } else {
                out.print("<script>location.href='BookServlet?method=queryAll'</script>");
            }
        } else {
            out.print("<script>alert('身份验证错误！');location.href='login/login.jsp'</script>");
        }
    }

    /**
     * 退出登陆
     */
    public void quit(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession(false);//防止创建Session
        session.removeAttribute("user");
        response.sendRedirect("login/login.jsp");

    }

    /**
     * 注册
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String user_name = request.getParameter("user_name");
        String user_pwd = request.getParameter("user_pwd");
        String user_email = request.getParameter("user_email");
        String user_phone = request.getParameter("user_phone");

        int user = dao.register(user_name, user_pwd, user_email, user_phone);

        if (user > 0) {
            out.print("<script>alert('注册成功！');location.href='login/login.jsp'</script>");
        } else {
            out.print("<script>alert('注册失败！');location.href='login/login.jsp'</script>");
        }
    }

    /**
     * 个人信息修改
     */
    public void editYourself(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);//防止创建Session
        session.removeAttribute("user");

        String user_id = request.getParameter("user_id");
        String user_phone = request.getParameter("user_phone");
        String user_name = request.getParameter("user_name");
        String user_pwd = request.getParameter("user_pwd");
        String user_email = request.getParameter("user_email");
        String user_address = request.getParameter("user_address");

        int rs = dao.editYourself(user_id, user_name, user_pwd, user_email, user_address);
        if (rs > 0) {
            request.getSession().setAttribute("user", dao.login(user_phone, user_pwd));
            out.print("<script>alert('修改成功！');location.href='index/userinfo.jsp'</script>");
        } else {
            out.print("<script>alert('修改失败！');location.href='index/userinfo.jsp'</script>");
        }
    }

    /**
     * 检查账号是否存在
     */
    public void isExist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_phone = request.getParameter("user_phone");
        User user = dao.isExist(user_phone);
        if (user == null) {
            this.outWirte(new JsonObject(new Header(0, "该手机号码可用", false), null), response);
        } else {
            this.outWirte(new JsonObject(new Header(10003, "该手机号码已存在，请输入新的手机号码", false), null), response);
        }
    }

    /**
     * 查找所有用户
     */
    public void queryUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String str_json = null;
        String search_data = null;
        search_data = request.getParameter("test");
        String pageNumber = request.getParameter("page");
        String pageSize = request.getParameter("rows");

        if (search_data != "") {
            str_json = dao.search(search_data);
        } else {
            str_json = dao.queryUsers(Integer.parseInt(pageNumber));
        }
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");

        PrintWriter pw = response.getWriter();
        pw.write(str_json);
    }


    /**
     * 查封,解封账号 操作
     * status ：1-正常用户，0-已冻结用户
     * 查封即将 status == 0
     * 解封即将 status == 1
     */
    public void dele(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String status = request.getParameter("status");
        String user_id = request.getParameter("user_id");

        int user = dao.dele(user_id, status);
        if (user == 1) {
            if ("1".equals(status)) {
                this.outWirte(new JsonObject(new Header(0, "账号已解封！", false), null), response);
            } else {
                this.outWirte(new JsonObject(new Header(0, "账号已冻结！", false), null), response);
            }
        } else {
            this.outWirte(new JsonObject(new Header(10003, "用户操作失败！", false), null), response);
        }
    }

    /**
     * 管理模块修改用户信息
     */
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String row = request.getParameter("row");

        JSONArray array = JSONArray.fromObject(row);
        Object[] obj = array.toArray();
        JSONObject object = JSONObject.fromObject(obj[0]);

        User user = (User) JSONObject.toBean(object, User.class);
        int rs = dao.edit(user.getUser_id(), user.getUser_name(), user.getUser_address());

        if (rs == 1) {
            this.outWirte(new JsonObject(new Header(0, "已修改", false), null), response);
        } else {
            this.outWirte(new JsonObject(new Header(10003, "修改失败", false), null), response);
        }
    }

}
