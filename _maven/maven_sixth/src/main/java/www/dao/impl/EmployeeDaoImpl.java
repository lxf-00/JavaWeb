package www.dao.impl;

import www.dao.EmployeeDao;
import www.domain.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public List<Employee> findAll() throws Exception{
        List<Employee> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            // 1，加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            // 2, 获取Connection 连接对象
            conn = DriverManager.getConnection("jdbc:mysql://172.16.36.164:3306/java_sql1", "root", "123456");
            // 3，定义sql语句
            String sql = "select * from emp;";
            // 4， 创建Statement对象
            stm = conn.prepareCall(sql);
            // 5， 执行
            rs = stm.executeQuery();
            // 6，将结果转为Java的List集合

            while (rs.next()) {
                Employee e = new Employee();
                e.setId(rs.getInt("id"));
                e.setName(rs.getString("name"));
                e.setPassword(rs.getString("password"));

                list.add(e);
            }
        }catch (Exception E){
            E.printStackTrace();
        }finally {
            rs.close();
            stm.close();
            conn.close();
        }

        return list;
    }
}
