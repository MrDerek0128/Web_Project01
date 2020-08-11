package JAVA.bean;

import JAVA.mapper.RequestParam;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class Text implements RequestParam {
    private int id;
    private String topic;
    private String content;
    private String writer;

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

    public String getWriter() {
        return writer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public List paramsList() {
        List list = new ArrayList();
        list.add(topic);
        list.add(content);
        list.add(writer);
        return list;
    }
}
