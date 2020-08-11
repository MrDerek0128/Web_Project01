package JAVA.mapper.realize;

import JAVA.mapper.ResultMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IntMapper implements ResultMapper {
    @Override
    public Object mapper(ResultSet rs) throws Exception {
        List<Integer> totals = new ArrayList<>();
        while (rs.next()) {
            totals.add(rs.getInt(1));
        }
        return totals;
    }
}
