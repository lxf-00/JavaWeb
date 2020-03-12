package le.javalearning.dao;

import le.javalearning.domain.User;
import le.javalearning.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 操作数据库中的user类
 */
public class UserDao {

    // 声明JDBCUtilTemplate对象共用
    private static JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return 存在返回user包含用户全部数据,没有查询到，返回null
     */
    public  User login(User loginUser){
        try {
            // 编写sql语句
            String sql = "select * from user where name = ? and password = ?;";
            // 调用query方法
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getName(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
