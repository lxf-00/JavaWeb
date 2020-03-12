package com.userInfoSearch.dao.impl;



import com.userInfoSearch.dao.UserDao;
import com.userInfoSearch.domain.User;
import com.userInfoSearch.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
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

    @Override
    public User findUserByUsernameAndPassword(String name, String password) {
        try {
            String sql = "select * from user where name= ? and password= ?;";
            // User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username, password);
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);

            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void addUser(User user) {
        // sql语句
        String sql = "insert into user values (null, ?, ?, ?, ?, ?, ?, null);";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail());

    }

    @Override
    public void deleteUser(int id) {
        // 定义sql语句
        String sql = "delete from user where id = ?;";
        // 执行语句
        template.update(sql, id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id = ?;";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        // 定义模板，初始化sql
        String sql = "select count(*) from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        // 遍历map
        Set<String> keySet = condition.keySet();
        // 定义参数的集合
        List<Object> params = new ArrayList<>();
        for(String key : keySet){
            // 排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            // 获取value
            String value = condition.get(key)[0];
            // 判断value是否有值
            if(value != null && !"".equals(value)){
                // 有值
                sb.append(" and " + key + " like ?");
                params.add("%" + value + "%");
            }
        }
        System.out.println("查询满足条件的总记录数sql语句：" +sb.toString());
        System.out.println("参数列表：" + params);

        //queryForObject()方法中，如果需要返回的是int类型，就写Integer.class,需要返回long类型就写long.class.
        return template.queryForObject(sb.toString(), Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        // 遍历map
        Set<String> keySet = condition.keySet();
        // 定义参数的集合
        List<Object> params = new ArrayList<>();
        for(String key : keySet){
            //排除分页条件参数
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if(value != null && !"".equals(value)){
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");//？条件的值
            }
        }
        //添加分页查询
        /*sb.append(" limit ?,?;");*/
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println("查询满足条件的全部用户的sql语句：" + sql);
        System.out.println("参数列表：" + params);


        List<User> query = template.query(sql, new BeanPropertyRowMapper<User>(User.class), params.toArray());
        System.out.println("query.size:" + query.size());
        return query;
    }
}
