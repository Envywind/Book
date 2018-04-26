package book.service.upload.impl;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import book.core.commonUtils.CommonUtils;
import book.core.handle.TxQueryRunner;
import book.service.upload.pojo.Book_file;
import book.service.upload.utils.MySqlHelper;
import book.service.users.pojo.User;

public class UploadHelper {

    public static Book_file returnFileBean(User user, String file_path, HttpServletRequest request) throws Exception {

        /*
         * 上传三步
         */
        // 工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 解析�?
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setFileSizeMax(1024 * 1024 * 10);// 限制单个文件大小�?10M

        List<FileItem> list = sfu.parseRequest(request);
        FileItem fi = list.get(0);

        String filename = fi.getName();// 获取上传的文件名�?
        String fileType = filename.substring(filename.lastIndexOf(".") + 1);// 获取上传的文件类�?

        /*
         * 处理文件名的绝对路径问题
         */
        int index = filename.lastIndexOf("\\");
        if (index != -1) {
            filename = filename.substring(index + 1);
        }
        /*
         * 给文件名称添加uuid前缀，处理文件同名问题
         */
        String uuid = CommonUtils.uuid();//生成长度32的随机字符，通常用来做实体类的id和激活码。保证数据库表主键和激活码的唯一性。
        String savename = uuid + "." + fileType;

        /*
         * 2. 获取hex的前两个字母，与root连接在一起，生成1个完整的路径
         */
        File dirFile = new File(file_path + "/" + "images");
        System.out.println(dirFile);
        /*
         * 3. 创建目录�?
         */
        dirFile.mkdirs();

        /*
         * 4. 创建目录文件
         */
        File destFile = new File(dirFile, savename);
        System.out.println(destFile);
        /*
         * 5. 保存
         */
        fi.write(destFile);
        Book_file bookfile = new Book_file();

        long ID = MySqlHelper.getSequnceNext("b_book_file");

        bookfile.setBook_img_id(ID);
        bookfile.setBook_image_name(filename);
        bookfile.setFile_path("uploadFile/images/" + savename);
        bookfile.setUpload_user(user == null ? "admin" : user.getUser_name());
        bookfile.setFile_size(fi.getSize());
        bookfile.setFile_type(fileType);

        QueryRunner qr = new TxQueryRunner();

        String sql = "INSERT INTO b_book_file(book_id,book_img_id,book_img_name,"
                + "upload_user,upload_time,file_path,file_type,file_size) "
                + "VALUES (?,?,?,?,DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'),?,?,?)";

        qr.update(sql, new Object[]{Long.valueOf(bookfile.getBook_img_id()),
                Long.valueOf(bookfile.getBook_img_id()), bookfile.getBook_img_name(),
                bookfile.getUpload_user(), bookfile.getFile_path(),
                bookfile.getFile_type(), Long.valueOf(bookfile.getFile_size())});

        String sq = "UPDATE b_book SET book_img_id=? WHERE book_id=?";
        qr.update(sq, new Object[]{Long.valueOf(bookfile.getBook_img_id()), Long.valueOf(bookfile.getBook_img_id())});

        return bookfile;
    }

}
