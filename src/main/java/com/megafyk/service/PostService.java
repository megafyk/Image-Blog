package com.megafyk.service;

import com.megafyk.model.Post;

import java.util.List;

public interface PostService {
    Post findPostById(int id);

    Post findPostByAuthor(String author);

    Post findPostByTag(String tag);

    Post findPostBytitle(String title);

    void savePost(Post post);

    void updatePost(Post post);

    void deletePostByTitle(String title);

    List<Post> findAllPosts();

    List<Post> scrollPosts(int firstResult, int maxResults);

    int getTotalRecords();

    boolean isPostTitleIsUnique(Integer id, String title);
}
