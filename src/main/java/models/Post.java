package models;

import java.util.List;

public class Post {
    private int id;
    private int user_id;
    private String title;
    private String content;
    private List<String> comments;
    private int isComment;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public int getIsComment() {
        return isComment;
    }

    public void setIsComment(int isComment) {
        this.isComment = isComment;
    }

    public Post(int id, int user_id, String title, String content, int isComment) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.isComment = isComment;
    }



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
}
