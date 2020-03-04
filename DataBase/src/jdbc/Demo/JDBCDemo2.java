package jdbc.Demo;

import jdbc.Demo.domain.Emp;
import jdbc.Demo.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo2 {
    /**练习：
     *  定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
     * 				1. 定义Emp类
     * 				2. 定义方法 public List<Emp> findAll(){}
     * 				3. 实现方法 select * from emp;
     */
    public static void main(String[] args) {
        // 调用方法
        List<Emp> all = findAll();
        for (Emp emp : all) {
            System.out.println(emp);
        }
    }

    // findAll()
    public static List<Emp> findAll(){
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        List<Emp> list = null;
        try {
            // 获取Connection 对象
            conn = JDBCUtils.getConnection();
            // sql 语句
            String sql = "select * from emp;";
            // 获取Statement对象
            stm = conn.createStatement();
            // 执行sql语句
            rs = stm.executeQuery(sql);

            // 创建Emp类型的集合
            list = new ArrayList<>();
            // 循环创建Emp对象并添加到集合中
            while(rs.next()){
                list.add(new Emp(rs.getInt("id"), rs.getString("name")));
            }

        }catch (SQLException E){
            E.printStackTrace();
        }finally {
            JDBCUtils.close(rs, stm, conn);
        }
        return list;
    }
}
