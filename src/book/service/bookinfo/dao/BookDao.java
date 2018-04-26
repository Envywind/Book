package book.service.bookinfo.dao;

import java.util.List;

import book.service.bookinfo.pojo.Book;

public interface BookDao {

    /**
     * 主页显示所有书籍
     */
    public List<Book> queryAll();

    /**
     * 书籍详情页面
     */
    public List<Book> queryByID(String book_id);

    /**
     * 书籍搜索
     */
    public List<Book> queryByName(String book_name);

    /**
     * 数据库书籍类目条数
     */
    public Book queryCount(String tableName);

    /**
     * 管理模块显示所有书籍
     */
    public List<Book> queryBook(String pageNumber, String pageSize);

    /**
     * 管理模块显示所有书籍图片
     */
    public List<Book> queryImg(String pageNumber, String pageSize);

    /**
     * 管理模块书籍上架
     */
    public int addBook(String book_name, String book_type, String book_price,
                       String book_author, String book_publish, String book_translate,
                       String book_description, String book_published_time);

    /**
     * 管理模块修改书籍
     */
    public int editBook(int book_id, String book_name, String book_type, String book_price,
                        String book_author, String book_publish, String book_translate, String book_description,
                        String book_published_time);


}
