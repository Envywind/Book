package book.service.upload.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.core.servlet.BaseServlet;

import book.service.upload.impl.UploadHelper;
import book.service.upload.pojo.Book_file;
import book.service.users.pojo.User;

public class UploadServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

    public void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        User user = (User) request.getSession().getAttribute("user");

        //获取项目路径
        String file_path = this.getServletConfig().getServletContext().getRealPath("/uploadFile");

        System.out.println(file_path);
        Map<String, Object> map = new HashMap<String, Object>();

        try {
            Book_file ufile = UploadHelper.returnFileBean(user, file_path, request);

            if (ufile != null) {
                map.put("result", "1");
                map.put("file_path", "uploadFile" + ufile.getFile_path());
                map.put("file_id", ufile.getBook_img_id());
            } else {
                map.put("result", "0");
            }
            out.print("<script>alert('上传成功！');location.href='admin/Book.jsp';</script>");
        } catch (Exception e) {
            /*this.outWirte(response, new JsonObject(new Header(500, "", false), map));*/
            e.printStackTrace();
        }

    }
}