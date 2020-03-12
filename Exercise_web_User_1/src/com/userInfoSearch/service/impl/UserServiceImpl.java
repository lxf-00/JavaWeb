package com.userInfoSearch.service.impl;


import com.userInfoSearch.dao.UserDao;
import com.userInfoSearch.dao.impl.UserDaoImpl;
import com.userInfoSearch.domain.PageBean;
import com.userInfoSearch.domain.User;
import com.userInfoSearch.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao =  new UserDaoImpl();

    @Override
    public List<User> findAll() {
       return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getName(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }

    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelectUser(String[] ids) {
        if(ids != null && ids.length > 0){
            for(String id : ids){
                dao.deleteUser(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage <= 0){
            currentPage = 1;
        }
        // 1，创建空的PageBean对象
        PageBean<User> pb = new PageBean<User>();
        // 2，设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 3，调用dao查询满足条件的总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        // 4，使用dao查询List集合
            // 计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage(start, rows, condition);
        pb.setList(list);

        // 5，计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount/rows:(totalCount/rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
