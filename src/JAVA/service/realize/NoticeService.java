package JAVA.service.realize;

import JAVA.Dao.NoticeDao;
import JAVA.Dao.TextDao;
import JAVA.bean.Notice;
import JAVA.bean.Text;
import JAVA.service.Service;

import java.util.List;

public class NoticeService implements Service {
    NoticeDao noticeDao = new NoticeDao();

    @Override
    public Object checkLogin(String username, String password) {
        return null;
    }

    @Override
    public int insert(Object o) {
        Notice notice = (Notice) o;
        return noticeDao.insert(notice);
    }

    @Override
    public List queryAll(int start, int last) {
        return noticeDao.queryAll(start, last);
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public int total() {
        return noticeDao.total();
    }
}
