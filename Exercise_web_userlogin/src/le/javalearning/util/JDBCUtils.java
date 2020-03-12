package le.javalearning.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC 工具类，使用druid
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            // 进行配置
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties pro = new Properties();
            pro.load(is);

            // 初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException E){
            E.printStackTrace();
        } catch (Exception E1){
            E1.printStackTrace();
        }
    }

    /**
     * 获取连接池对象
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 获取连接池对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(ResultSet rs, Statement stm, Connection conn){
        if(rs != null){
            try{
                rs.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(stm != null){
            try{
                stm.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

        if(conn != null){
            try{
                conn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
