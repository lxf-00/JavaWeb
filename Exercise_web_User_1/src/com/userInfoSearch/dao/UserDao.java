package com.userInfoSearch.dao;




import com.userInfoSearch.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户信息数据库操作 DAO
 */
public interface UserDao {
    /**
     * 查询所有的用户信息
     */
    public List<User> findAll();

    /**
     * 根据用户名密码查询管理员用户
     * @param name
     * @param password
     * @return
     */
    User findUserByUsernameAndPassword(String name, String password);

    /**
     * 新增用户
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 删除用户信息
     * @param id
     */
    void deleteUser(int id);

    /**
     * 通过用户id,查询用户
     * @param id
     */
    User findById(int id);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据条件查询总记录数
     * @param condition
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     * @return
     */
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);


}
