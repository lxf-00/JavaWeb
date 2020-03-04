package Druid.Demo;

import Druid.Demo.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DruidDemo2 {
    /**
     * 使用JDBCUtils 工具类
     */
    public static void main(String[] args) throws Exception {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {
            // 获取Connection
            conn = JDBCUtils.getConnection();
            // sql
            String sql = "select * from emp;";
            // Statement
            stm = conn.createStatement();
            // 执行
            rs = stm.executeQuery(sql);
            // 打印
            while(rs.next()){
                System.out.println(rs.getInt("id") + "...." + rs.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtils.close(rs, stm, conn);
        }
    }
}
