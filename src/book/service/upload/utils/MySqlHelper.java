package book.service.upload.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import book.core.handle.TxQueryRunner;
import book.service.upload.pojo.Book_file;

public class MySqlHelper {

    public static long getSequnceNext(String tableName) throws Exception {
        try {

            String sql = "SELECT (CASE WHEN MAX(t.book_img_id) IS NULL THEN 1 ELSE (MAX(t.book_img_id) + 1) END) book_img_id FROM " + tableName + " t";
            QueryRunner qr = new TxQueryRunner();
            return qr.query(sql, new BeanHandler<Book_file>(Book_file.class)).getBook_img_id();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
