package Druid.Demo;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import jdbc.Demo.utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo1 {
    /**
     * druid 连接演示
     */
    public static void main(String[] args) throws Exception {
        // 加载配置文件
        Properties pro = new Properties();
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        // 获取DataSource对象
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        // 获取Connection 对象
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }
}
