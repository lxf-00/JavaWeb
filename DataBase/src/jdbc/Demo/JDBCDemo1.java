package jdbc.Demo;

import jdbc.Demo.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo1 {
    /**
     * 需求：
     * 		1. 通过键盘录入用户名和密码
     * 		2. 判断用户是否登录成功
     */
    public static void main(String[] args) {
        // 获取用户的 信息
        System.out.println("请输入用户名：");
        String user = new Scanner(System.in).nextLine();
        System.out.println("请输入密码：");
        String password = new Scanner(System.in).nextLine();

        // 调用方法验证： loginVerify(String user, String password)
        loginVerify(user, password);
    }

    // loginVerify()
    public static void loginVerify(String user, String password){
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            // 获取Connection 对象
            conn = JDBCUtils.getConnection();
            // sql
            String sql = "select * from emp where name = ? and password = ?;";
            // 获取PreparedStatement 对象
            stm = conn.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, password);
            // 查询集
            rs = stm.executeQuery();
            // 判断
            if(rs.next()){
                System.out.println(user + ",欢迎登录.....");
            }else{
                System.out.println("账号或密码错误....");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.close(rs, stm, conn);
        }
    }
}
