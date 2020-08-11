package JAVA.mapper.realize;

import JAVA.bean.Text;
import JAVA.mapper.ResultMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TextMapper implements ResultMapper {
    @Override
    public List<Text> mapper(ResultSet rs) throws Exception {
        List<Text> texts = new ArrayList<>();
        while (rs.next()) {
            Text text = new Text();
            text.setId(rs.getInt("id"));
            text.setTopic(rs.getString("topic"));
            text.setContent(rs.getString("content"));
            text.setWriter(rs.getString("writer"));
            texts.add(text);
        }
        return texts;
    }
}
