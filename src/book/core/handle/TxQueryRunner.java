package book.core.handle;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import book.core.dbutils.DBUtils;

/**
 * 执行器
 *
 * @author assassin
 */
public class TxQueryRunner extends QueryRunner {

    public int[] batch(String sql, Object[][] params) throws SQLException {
        Connection con;
        try {
            con = DBUtils.getConnection();
            int[] result = super.batch(con, sql, params);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
            throws SQLException {
        Connection con;
        try {
            con = DBUtils.getConnection();
            T result = super.query(con, sql, rsh, params);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con;
        try {
            con = DBUtils.getConnection();
            T result = super.query(con, sql, rsh);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int update(String sql) throws SQLException {
        Connection con;
        try {
            con = DBUtils.getConnection();
            int result = super.update(con, sql);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(String sql, Object param) throws SQLException {
        Connection con;
        try {
            con = DBUtils.getConnection();
            int result = super.update(con, sql, param);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int update(String sql, Object... params) throws SQLException {
        Connection con;
        try {
            con = DBUtils.getConnection();
            int result = super.update(con, sql, params);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

