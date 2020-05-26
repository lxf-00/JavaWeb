package com.demo;

import oracle.jdbc.driver.OracleTypes;
import org.junit.Test;

import java.sql.*;

public class OracleConnection {
    /**
     * oracle 数据库的连接
     */
    @Test
    public void testOjdbc1(){
        String driver="oracle.jdbc.OracleDriver";
        String url="jdbc:oracle:thin:@172.16.36.147:1521:orcl";
        String username="scott";
        String password="scott";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from emp");

            while(rs.next()){
                System.out.println(rs.getObject(1)+ "," + rs.getObject(2));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 过程调用
     */
    @Test
    public void testOjdbc2(){
        String driver="oracle.jdbc.OracleDriver";
        String url="jdbc:oracle:thin:@172.16.36.147:1521:orcl";
        String username="scott";
        String password="scott";
        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);

            CallableStatement callSt = conn.prepareCall("{call proc_countyearsal(?,?)}");
            callSt.setInt(1, 7839);
            callSt.registerOutParameter(2, OracleTypes.NUMBER);
            callSt.execute();

            System.out.println(callSt.getObject(2));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
