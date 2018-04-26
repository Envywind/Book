package book.service.bookinfo.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import book.core.handle.TxQueryRunner;
import book.service.bookinfo.dao.BookDao;
import book.service.bookinfo.pojo.Book;

public class BookImpl implements BookDao {

    private QueryRunner qr = new TxQueryRunner();

    /**
     * 主页显示所有书籍
     */
    public List<Book> queryAll() {
        try {
            String sql = "SELECT f.file_path,k.book_name,k.book_price,k.book_type,k.book_id "
                    + " FROM b_book k, b_book_file f "
                    + " WHERE k.book_img_id=f.book_img_id";
            return qr.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 书籍详情页面
     */
    public List<Book> queryByID(String book_id) {
        try {
            String sql = "SELECT k.book_id,k.book_name,k.book_author,"
                    + " k.book_translate, k.book_price,k.book_type,k.book_publish,"
                    + " k.book_published_time, k.book_description,t.file_path "
                    + " FROM b_book k,b_book_file t "
                    + " WHERE k.book_img_id=t.book_img_id AND k.book_id=?";
            return qr.query(sql, new BeanListHandler<Book>(Book.class), book_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 书籍搜索
     */
    public List<Book> queryByName(String book_name) {
        try {
            String sql = "SELECT f.file_path,k.book_name,k.book_price,k.book_type,k.book_id "
                    + " FROM b_book k, b_book_file f "
                    + " WHERE k.book_name LIKE '%" + book_name + "%'"
                    + " AND k.book_img_id=f.book_img_id";
            return qr.query(sql, new BeanListHandler<Book>(Book.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 管理模块显示所有书籍
     */
    public List<Book> queryBook(String pageNumber, String pageSize) {
        try {
            int start = (Integer.parseInt(pageNumber) - 1) * Integer.parseInt(pageSize);
            int end = Integer.parseInt(pageNumber) * Integer.parseInt(pageSize);
            String sql = "SELECT k.book_id,k.book_img_id,k.book_name,k.book_name,k.book_author,"
                    + "k.book_translate, k.book_price,k.book_type,k.book_publish,"
                    + "k.book_published_time, k.book_description,t.file_path "
                    + "FROM b_book k,b_book_file t "
                    + "WHERE k.book_id=t.book_id "
                    + "ORDER BY book_id DESC LIMIT ?,?";
            Object[] params = {start, end};
            return qr.query(sql, new BeanListHandler<Book>(Book.class), params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 管理模块显示所有书籍图片
     */
    public List<Book> queryImg(String pageNumber, String pageSize) {
        try {
            int start = (Integer.parseInt(pageNumber) - 1) * Integer.parseInt(pageSize);
            int end = Integer.parseInt(pageNumber) * Integer.parseInt(pageSize);
            String sql = "SELECT * FROM b_book_file ORDER BY book_id DESC LIMIT ?,?";
            Object[] params = {start, end};
            return qr.query(sql, new BeanListHandler<Book>(Book.class), params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 数据库书籍类目条数
     */
    public Book queryCount(String tableName) {
        try {
            String sql = "SELECT COUNT(1) as count FROM " + tableName + "";
            return qr.query(sql, new BeanHandler<Book>(Book.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 管理模块书籍上架
     */
    public int addBook(String book_name, String book_type, String book_price, String book_author, String book_publish,
                       String book_translate, String book_description, String book_published_time) {
        try {
            String sql = "INSERT INTO b_book(book_name,book_type,book_price,book_author,"
                    + " book_publish,book_translate,book_description,book_published_time) "
                    + " VALUES(?,?,?,?,?,?,?,?)";
            Object[] params = {book_name, book_type, book_price, book_author, book_publish,
                    book_translate, book_description, book_published_time};
            return qr.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 管理模块修改书籍
     */
    public int editBook(int book_id, String book_name, String book_type, String book_price,
                        String book_author, String book_publish, String book_translate, String book_description,
                        String book_published_time) {
        try {
            String sql = "UPDATE b_book SET book_name=?,book_type=?,book_price=?,book_author=?,"
                    + " book_publish=?,book_translate=?,book_description=?,book_published_time=? "
                    + " WHERE book_id=?";
            Object[] params = {book_name, book_type, book_price, book_author, book_publish,
                    book_translate, book_description, book_published_time, book_id};
            return qr.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
