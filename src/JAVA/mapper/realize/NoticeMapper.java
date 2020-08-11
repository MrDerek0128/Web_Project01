package JAVA.mapper.realize;

import JAVA.bean.Notice;
import JAVA.bean.Text;
import JAVA.mapper.ResultMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoticeMapper implements ResultMapper {
    @Override
    public List<Notice> mapper(ResultSet rs) throws Exception {
        List<Notice> notices = new ArrayList<>();
        while (rs.next()) {
            Notice notice = new Notice();
            notice.setId(rs.getInt("id"));
            notice.setTopic(rs.getString("topic"));
            notice.setContent(rs.getString("content"));
            notice.setDate(rs.getString("date"));
            notices.add(notice);
        }
        return notices;
    }
}
