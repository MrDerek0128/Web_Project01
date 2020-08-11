package JAVA.mapper;

import java.sql.ResultSet;

public interface ResultMapper<T> {
    T mapper (ResultSet rs) throws Exception;
}
