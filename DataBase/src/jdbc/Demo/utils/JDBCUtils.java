package jdbc.Demo.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    /**
     * JDBCUtils 工具类
     */

    // 成员变量
    private static String url;
    private static String user;
    private static String password;

    static{
        try {
            // 获取配置文件
            Properties pro = new Properties();
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("pro.properties");
            pro.load(is);

            url = pro.getProperty("url");
            user = pro.getProperty("userName");
            password = pro.getProperty("password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Connection
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     */
    public static void close(ResultSet rs, Statement stm, Connection conn){
        if(rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        if (stm != null){
            try {
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     */
    public static void close(Statement stm, Connection conn){
        close(null, stm, conn);
    }


}
