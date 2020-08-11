package JAVA.service.realize;

import JAVA.Dao.TextDao;
import JAVA.bean.Text;
import JAVA.bean.User;
import JAVA.service.Service;

import java.util.List;

public class TextService implements Service {
    TextDao textDao = new TextDao();

    @Override
    public Object checkLogin(String username, String password) {
        return null;
    }

    @Override
    public int insert(Object o) {
        Text text = (Text) o;
        return textDao.insert(text);
    }

    @Override
    public List queryAll(int start, int last) {
        return textDao.queryAll(start, last);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int total() {
        return textDao.total();
    }
}
