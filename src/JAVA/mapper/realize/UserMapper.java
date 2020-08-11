package JAVA.mapper.realize;

import JAVA.bean.User;
import JAVA.mapper.ResultMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserMapper implements ResultMapper<List<User>> {
    @Override
    public List<User> mapper(ResultSet rs) throws Exception {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setName(rs.getString("name"));
            user.setSex(rs.getString("sex"));
            user.setAge(rs.getInt("age"));
            user.setRig(rs.getInt("rig"));
            users.add(user);
        }
        return users;
    }
}
