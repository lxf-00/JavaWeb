package jdbc.Demo;

import jdbc.Demo.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stm = null;

        try{
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            // sql 语句
            String sql = "update emp set password = '123456' where name = '张三'";
            // 获取Statement对象
            stm = conn.createStatement();
            // 制造异常
            int i = 3 / 0;
            // 执行SQL
            int res = stm.executeUpdate(sql);
            // 提交事务
            conn.commit();
        } catch (Exception E){
            // 回滚
            try{
                if(conn != null){
                    conn.rollback();

                }
            }catch (SQLException e){
                e.printStackTrace();
            }
            E.printStackTrace();
        }finally{
            JDBCUtils.close(stm, conn);
        }

    }
}
