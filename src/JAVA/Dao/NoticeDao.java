package JAVA.Dao;

import JAVA.Utils.JdbcTemplate;
import JAVA.bean.Notice;
import JAVA.bean.Text;
import JAVA.mapper.realize.IntMapper;
import JAVA.mapper.realize.NoticeMapper;
import JAVA.mapper.realize.TextMapper;

import java.util.List;

public class NoticeDao {
    public int total() {
        List<Integer> totals = JdbcTemplate.query("select count(*) from notice", new IntMapper());
        return totals.get(0);
    }

    public List<Notice> queryAll(int start, int late) {
        List<Notice> notices = JdbcTemplate.query("select * from notice order by id asc limit ?,?",
                new NoticeMapper(), start, late);
        return notices;
    }

    public int insert (Notice notice) {
        return JdbcTemplate.insert("insert into notice (topic, content, date) values (?, ?, ?)"
                , notice);
    }
}
