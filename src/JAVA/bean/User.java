package JAVA.bean;

import JAVA.mapper.RequestParam;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class User implements RequestParam {
    private int id;
    private String username;
    private String password;
    private String name;
    private String sex;
    private int age;
    private int rig = 0;

    public void setRig(int rig) {
        this.rig = rig;
    }

    public int getRig() {
        return rig;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public List paramsList() {
        List list = new ArrayList();
        list.add(username);
        list.add(password);
        list.add(name);
        list.add(sex);
        list.add(age);
        return list;
    }
}
