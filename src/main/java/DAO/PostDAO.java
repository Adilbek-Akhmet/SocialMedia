package DAO;

import models.Post;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    public static PostDAO PostDAO = new PostDAO();
    private static List<Post> posts = new ArrayList<Post>();
    private static Connection connection = DB.getInstance().getConnection();

    private PostDAO() {}

    public static PostDAO getInstance() {
        return PostDAO;
    }

    public void addPost(String title, String content, int visibility) {
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("INSERT INTO posts (title, content, visibility) VALUES (?, ?, ?)");
            ps.setString(1, title);
            ps.setString(2, content);
            ps.setInt(3, visibility);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addComment(int post_id, String comment) {
        try {
            PreparedStatement ps = connection.prepareStatement
                    ("insert into comments(post_id, comment) values(?, ?)");
            ps.setInt(1, post_id);
            ps.setString(2, comment);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Post> getAllPosts() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from posts");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                int user_id = resultSet.getInt(2);
                String title = resultSet.getString(3);
                String content = resultSet.getString(4);
                int isComment = resultSet.getInt(5);

                Post post = new Post(id, user_id, title, content, isComment);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public List<String> getComment(int post_id) {
        List<String> comments = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from comments where post_id = ?");
            preparedStatement.setInt(1, post_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String comment = resultSet.getString(3);
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
