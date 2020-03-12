package www.UserList.service.impl;

import www.UserList.dao.UserDao;
import www.UserList.dao.impl.UserDaoImpl;
import www.UserList.domian.User;
import www.UserList.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> findAll() {
       UserDao dao =  new UserDaoImpl();

       return dao.findAll();
    }
}
