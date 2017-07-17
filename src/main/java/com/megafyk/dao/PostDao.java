package com.megafyk.dao;

import com.megafyk.model.Post;
import javafx.geometry.Pos;

import java.util.List;

public interface PostDao {
    Post findPostById(int id);

    Post findPostByAuthor(String author);

    Post findPostByTag(String tag);

    Post findPostByTitle(String title);

    void savePost(Post post);

    void deletePostByTitle(String title);

    List<Post> findAllPosts();

    int getTotalRecords();

    List<Post> scrollPosts(int firstResult, int maxResults);
}
