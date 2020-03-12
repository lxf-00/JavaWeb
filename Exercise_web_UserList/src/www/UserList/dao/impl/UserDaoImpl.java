package www.UserList.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import www.UserList.dao.UserDao;
import www.UserList.domian.User;
import www.UserList.util.JDBCUtils;

import java.util.List;

public class UserDaoImpl  implements UserDao {
    // 创建JdbcTemplate 对象
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        // 定义sql语句
        String sql = "select * from user;";
        // 查询封装
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return users;
    }
}
