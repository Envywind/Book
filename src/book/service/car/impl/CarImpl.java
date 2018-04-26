package book.service.car.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import book.core.handle.TxQueryRunner;
import book.service.car.dao.CarDao;
import book.service.car.pojo.Car;

public class CarImpl implements CarDao {

    private QueryRunner qr = new TxQueryRunner();

    @Override
    public List<Car> queryPrice(String id) {
        try {
            String sql = "SELECT k.book_price FROM b_book k WHERE k.book_id=?";
            return qr.query(sql, new BeanListHandler<Car>(Car.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加到购物车
     */
    public int addCar(int user_id, String book_id, String book_price) {
        try {
            String sql = "INSERT INTO b_car(book_id,user_id,num,total_sum) "
                    + "	VALUES(?,?,'1',?)";
            Object[] params = {book_id, user_id, book_price};
            return qr.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查看购物车
     */
    public List<Car> queryCar(int user_id) {
        try {
            String sql = "SELECT c.c_id,c.book_id,b.book_name,f.file_path,b.book_price,c.num,c.total_sum "
                    + " FROM b_user u,b_car c,b_book b,b_book_file f "
                    + " WHERE u.user_id=c.user_id "
                    + " AND c.book_id=b.book_id "
                    + " AND b.book_img_id=f.book_img_id "
                    + " AND u.user_id=?";
            return qr.query(sql, new BeanListHandler<Car>(Car.class), user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 购物车删除商品
     */
    public int dele(String c_id) {
        try {
            String sql = "UPDATE  b_car SET status=2 WHERE c_id=?";
            return qr.update(sql, c_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


}
