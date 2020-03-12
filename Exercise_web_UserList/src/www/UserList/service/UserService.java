package www.UserList.service;

import www.UserList.domian.User;

import java.util.List;

/**
 * 用户信息相关业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     */
    List<User> findAll();
}
