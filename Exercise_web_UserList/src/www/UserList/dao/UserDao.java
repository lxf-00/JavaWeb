package www.UserList.dao;


import www.UserList.domian.User;

import java.util.List;

/**
 * 用户信息数据库操作 DAO
 */
public interface UserDao {
    /**
     * 查询所有的用户信息
     */
    public List<User> findAll();
}
