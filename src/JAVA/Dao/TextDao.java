package JAVA.Dao;

import JAVA.Utils.JdbcTemplate;
import JAVA.bean.Text;
import JAVA.mapper.realize.IntMapper;
import JAVA.mapper.realize.TextMapper;

import java.util.List;

public class TextDao {
    public int total() {
        List<Integer> totals = JdbcTemplate.query("select count(*) from text", new IntMapper());
        return totals.get(0);
    }

    public List<Text> queryAll(int start, int late) {
        List<Text> texts = JdbcTemplate.query("select * from text order by id asc limit ?,?",
                new TextMapper(), start, late);
        return texts;
    }

    public int insert (Text text) {
        return JdbcTemplate.insert("insert into text (topic, content, writer) values (?, ?, ?)"
        , text);
    }
}
