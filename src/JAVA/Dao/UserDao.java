package JAVA.Dao;

import JAVA.Utils.JdbcTemplate;
import JAVA.bean.User;
import JAVA.mapper.realize.IntMapper;
import JAVA.mapper.realize.UserMapper;

import java.util.List;

public class UserDao {
    public User query(String username, String password) {
        List<User> users = JdbcTemplate.query("select * from user where username = ?"
        +"and password = ?", new UserMapper(), username, password);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    public User query(String username) {
        List<User> users = JdbcTemplate.query("select * from user where username = ?"
                , new UserMapper(), username);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    public User queryID(int id) {
        List<User> users = JdbcTemplate.query("select * from user where id = ?"
                , new UserMapper(), id);
        if (users.size() == 0) {
            return null;
        }
        return users.get(0);
    }

    public int right(int id) {
        List<User> users = JdbcTemplate.query("select * from user where id = ?",
                new UserMapper(), id);
        return users.get(0).getRig();
    }

    public int insert(User user) {
        return JdbcTemplate.insert("insert into user (username, password, name, sex, age)"+
                "values (?, ?, ?, ?, ?)", user);
    }

    public List<User> queryAll(int start, int last) {
        List<User> Users = JdbcTemplate.query("select * from user order by id asc limit ?,?",
                new UserMapper(), start, last);
        return Users;
    }

    public int total(){
        List<Integer> totals =  JdbcTemplate.query("select count(*) from user" ,new IntMapper());
        return totals.get(0);
    }

    public int delete(int id) {
        return (JdbcTemplate.update("delete from user where id = ?", id));
    }
}
