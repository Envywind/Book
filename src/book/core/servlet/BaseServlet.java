package book.core.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import book.core.utils.JsonObject;

public class BaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public BaseServlet() {
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");// 处理响应编码
        request.setCharacterEncoding("UTF-8");

        /**
         * <pre>
         *    通过反射机制   动态调用请求的方法
         * 1. 获取method参数，它是用户想调用的方法
         * 2. 把方法名称变成Method类的实例对象
         * 3. 通过invoke()来调用这个方法
         * </pre>
         */
        String methodName = request.getParameter("method");
        Method method = null;
        try {

            /**
             * 2. 通过方法名称获取Method对象
             */
            method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            /**
             * 3. 通过method对象来调用它
             */
            method.invoke(this, request, response);

        } catch (Exception e) {
            throw new RuntimeException("您要调用的方法：" + methodName + "不存在！", e);
        }

    }

    public void outWirte(JsonObject jsonObj, HttpServletResponse response) {
        response.reset();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out;
        try {
            out = response.getWriter();
            out.write(JSON.toJSONString(jsonObj));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
