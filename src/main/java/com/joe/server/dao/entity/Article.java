package com.joe.server.dao.entity;

/**
 * NOTE:Article Entity.
 * Created by zhouwd on 15-5-16.
 */
public class Article {
    private int id;
    private String title;
    private String content;
    private long dateTime;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" + " id=" + id +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dateTime=" + dateTime +
                ", author='" + author + '\'' +
                '}';
    }
}
