package JAVA.service;

import java.util.List;

public interface Service<T> {
    T checkLogin(String username, String password);
    int insert(T t);
    List<T> queryAll(int start, int last);
    int delete(int id);
    int total();
}
