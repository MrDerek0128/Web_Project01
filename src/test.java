import JAVA.Dao.NoticeDao;
import JAVA.Dao.TextDao;
import JAVA.Dao.UserDao;
import JAVA.bean.Text;
import JAVA.bean.User;
import JAVA.service.realize.TextService;
import JAVA.service.realize.UserService;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class test{
    public static void main(String[] args) throws Exception{
        TextDao textDao = new TextDao();
        System.out.println(textDao.queryAll(0,2));
    }
}
