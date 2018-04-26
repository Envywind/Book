package book.service.users.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import book.core.dbutils.DBUtils;
import book.core.handle.TxQueryRunner;
import book.core.utils.MD5Encryptor;
import book.service.users.dao.UserDao;
import book.service.users.pojo.User;

public class UserImpl implements UserDao {

    private QueryRunner qr = new TxQueryRunner();

    /**
     * 登录
     */
    public User login(String user_phone, String user_pwd) {
        try {
            String sql = "SELECT t.user_id,t.user_name,t.user_pwd,t.user_email,t.user_phone,t.user_address"
                    + " FROM b_user t "
                    + " WHERE user_phone=? AND user_pwd=?";
            Object[] param = {user_phone, MD5Encryptor.encrypt(user_pwd)};
            return qr.query(sql, new BeanHandler<User>(User.class), param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注册
     */
    public int register(String user_name, String user_pwd, String user_email, String user_phone) {
        try {
            String sql = "INSERT INTO b_user(user_name,user_pwd,user_email,user_phone,user_address,register_time) "
                    + "VALUES(?,?,?,?,'未填写',DATE_FORMAT(NOW(),'%Y-%m-%d %H:%i:%S'))";
            Object[] param = {user_name, MD5Encryptor.encrypt(user_pwd), user_email, user_phone};
            return qr.update(sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 个人信息修改
     */
    public int editYourself(String user_id, String user_name, String user_pwd, String user_email, String user_address) {
        try {
            String sql = "UPDATE  b_user SET user_name=?,user_pwd=?,user_email=?,user_address=?"
                    + " WHERE user_id=?";
            Object[] param = {user_name, MD5Encryptor.encrypt(user_pwd), user_email, user_address, user_id};
            return qr.update(sql, param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 检查账号是否存在
     */
    public User isExist(String user_phone) {
        try {
            String sql = "SELECT * FROM b_user WHERE user_phone=?";
            return qr.query(sql, new BeanHandler<User>(User.class), user_phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查找所有用户
     */
    public String queryUsers(int page) {
        int p = page == 1 ? 0 : ((page - 1) * 10);
        StringBuilder sb = new StringBuilder();
        String str = "";
        int total = 0;

        try {
            Connection conn = DBUtils.getConnection();
            String sq = "SELECT COUNT(*) FROM b_user WHERE status IN(0,1)";
            PreparedStatement ps = conn.prepareStatement(sq);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append("{\"total\":" + total + ",\"rows\":[");

        try {
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT t.status,t.user_id,t.user_phone,t.user_name,t.user_pwd,t.user_email,"
                    + " t.user_address, t.register_time FROM b_user t WHERE status IN(0,1)"
                    + " LIMIT " + p + ",10";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sb.append("{\"user_id\":" + rs.getInt("user_id")
                        + ",\"status\":" + rs.getInt("status")
                        + ",\"user_phone\":\"" + rs.getString("user_phone")
                        + "\",\"user_name\":\"" + rs.getString("user_name")
                        + "\",\"user_pwd\":\"" + rs.getString("user_pwd")
                        + "\",\"user_email\":\"" + rs.getString("user_email")
                        + "\",\"user_address\":\"" + rs.getString("user_address")
                        + "\",\"register_time\":\"" + rs.getString("register_time")
                        + "\"},");
            }
            str = sb.toString().substring(0, sb.toString().length() - 1);
            str += "]}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 搜索
     */
    public String search(String search_data) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        int total = 0;

        try {
            Connection conn = DBUtils.getConnection();
            String sq = "SELECT COUNT(*) FROM b_user "
                    + " WHERE user_phone LIKE '%" + search_data + "%'"
                    + " AND status IN(0,1)";
            PreparedStatement ps = conn.prepareStatement(sq);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        sb.append("{\"total\":" + total + ",\"rows\":[");

        try {
            Connection conn = DBUtils.getConnection();
            String sql = "SELECT t.status,t.user_id,t.user_phone,t.user_name,t.user_pwd,t.user_email,"
                    + " t.user_address, t.register_time FROM b_user t "
                    + " WHERE user_phone LIKE '%" + search_data + "%'"
                    + " AND status IN(0,1)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sb.append("{\"user_id\":" + rs.getInt("user_id")
                        + ",\"status\":" + rs.getInt("status")
                        + ",\"user_phone\":\"" + rs.getString("user_phone")
                        + "\",\"user_name\":\"" + rs.getString("user_name")
                        + "\",\"user_pwd\":\"" + rs.getString("user_pwd")
                        + "\",\"user_email\":\"" + rs.getString("user_email")
                        + "\",\"user_address\":\"" + rs.getString("user_address")
                        + "\",\"register_time\":\"" + rs.getString("register_time")
                        + "\"},");
            }
            str = sb.toString().substring(0, sb.toString().length() - 1);
            str += "]}";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 查封,解封账号
     */
    public int dele(String user_id, String status) {
        try {
            String sql = "UPDATE  b_user SET status=? WHERE user_id=?";
            return qr.update(sql, status, user_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 管理模块修改用户信息
     */
    public int edit(int user_id, String user_name, String user_address) {
        try {
            String sql = "UPDATE  b_user SET user_name=?,user_address=? WHERE user_id=?";
            Object[] params = {user_name, user_address, user_id};
            return qr.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
