package JAVA.Utils;

import JAVA.mapper.RequestParam;
import JAVA.mapper.ResultMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class JdbcTemplate {
    public static List query(String sql, ResultMapper resultMapper, Object...params) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            rs = ps.executeQuery();
            return (List) resultMapper.mapper(rs);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(ps, con);
        }
        return null;
    }

    public static int insert (String sql, RequestParam param) {
        Connection con = null;
        PreparedStatement ps = null;
        List list = param.paramsList();
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i<list.size(); i++){
                ps.setObject(i+1, list.get(i));
            }
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()){
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(ps, con);
        }
        return 0;
    }

    public static int update(String sql, Object...params) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = JdbcUtils.getConnection();
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i+1, params[i]);
            }
            return ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(ps, con);
        }
        return 0;
    }
}
