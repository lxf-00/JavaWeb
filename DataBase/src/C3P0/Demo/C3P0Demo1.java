package C3P0.Demo;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo1 {
    /**
     * C3P0 数据库连接池的使用演示
     * 1， 导包
     * 2， 配置文件
     * 3， 创建ComboPooledDataSource() 对象
     * 4， 获取Connection 对象
     */
    public static void main(String[] args) throws SQLException {
        // 获取ComboPoolDataSource() 对象
        DataSource ds = new ComboPooledDataSource();
        // 获取Connection 对象
        for(int i = 0; i < 10; i++){
            Connection conn = ds.getConnection();
            System.out.println(i + "___" + conn);
        }
    }
}
