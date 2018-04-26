package book.core.dbutils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class DBUtils {

    private static Properties pro = null;

    private static Connection conn;

    static {

        try {
            InputStream inStream = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
            pro = new Properties();
            pro.load(inStream);

            Class.forName(pro.getProperty("driverClass"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //获取数据库连接
    public static Connection getConnection() throws Exception {
        if (conn == null)
            conn = DriverManager.getConnection(pro.getProperty("url"), pro.getProperty("user"), pro.getProperty("password"));
        return conn;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(DBUtils.getConnection());
    }


}
