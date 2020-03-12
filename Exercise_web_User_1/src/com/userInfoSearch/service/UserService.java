package com.userInfoSearch.service;


import com.userInfoSearch.domain.PageBean;
import com.userInfoSearch.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户信息相关业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     */
    List<User> findAll();

    /**
     * 管理员登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    void addUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(int id);

    /**
     * 通过用户id,查看用户
     * @param id
     * @return
     */
   User findById(int id);

    /**
     * 更新用户信息
     * @param user
     */
   void updateUser(User user);

    /**
     * 批量删除用户
     * @param ids
     */
   void delSelectUser(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
   PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
