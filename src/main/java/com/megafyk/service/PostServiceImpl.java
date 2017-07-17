package com.megafyk.service;

import com.megafyk.dao.PostDao;
import com.megafyk.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("postService")
@Transactional
public class PostServiceImpl implements PostService {
    @Autowired
    PostDao dao;

    public Post findPostById(int id) {
        return dao.findPostById(id);
    }

    public Post findPostByAuthor(String author) {
        return dao.findPostByAuthor(author);
    }

    public Post findPostByTag(String tag) {
        return dao.findPostByTag(tag);
    }

    public Post findPostBytitle(String title) {
        return dao.findPostByTitle(title);
    }

    public void savePost(Post post) {
        dao.savePost(post);
    }

    public void updatePost(Post post) {
        Post entity = findPostById(post.getId());
        if (entity != null) {
            entity.setTitle(post.getTitle());
            entity.setTitle_clean(post.getTitle_clean());
            entity.setArticle(post.getArticle());
            entity.setAuthor_id(post.getAuthor_id());
            entity.setDate_published(post.getDate_published());
            entity.setStatus(post.isStatus());
            entity.setComments_enabled(post.isComments_enabled());
            entity.setViews(post.getViews());
            entity.setLikes(post.getLikes());
            entity.setImage_uri(post.getImage_uri());
        }
    }

    public void deletePostByTitle(String title) {
        dao.deletePostByTitle(title);
    }

    public List<Post> findAllPosts() {
        return dao.findAllPosts();
    }

    public List<Post> scrollPosts(int firstResult, int maxResults) {
        return dao.scrollPosts(firstResult, maxResults);
    }

    public int getTotalRecords(){
        return dao.getTotalRecords();
    }

    public boolean isPostTitleIsUnique(Integer id, String title) {
        Post post = findPostBytitle(title);
        return (post == null || ((id != null) && (post.getId() == id)));
    }
}
