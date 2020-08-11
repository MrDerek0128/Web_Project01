package JAVA.service.realize;

import JAVA.Dao.UserDao;
import JAVA.bean.User;
import JAVA.service.Service;

import java.util.List;

public class UserService implements Service {
    private UserDao userDao = new UserDao();

    @Override
    public User checkLogin(String username, String password) {
        User user = userDao.query(username, password);
        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public int insert(Object o) {
        User u = (User) o;
        User user = userDao.query(u.getUsername());
        if (user != null) {
            return 0;
        }
        return userDao.insert(u);
    }

    @Override
    public List queryAll(int start, int last) {
        return userDao.queryAll(start, last);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int total() {
        return userDao.total();
    }
}
