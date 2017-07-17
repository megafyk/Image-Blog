package com.megafyk.controller;

import com.megafyk.dao.PostDaoImpl;
import com.megafyk.model.Post;
import com.megafyk.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RestBlogController {
    static final Logger logger = LoggerFactory.getLogger(PostDaoImpl.class);

    @Autowired
    PostService postService;

    @RequestMapping(value = {"/post/page{page}"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Post>> listAllPost(@PathVariable("page") int page) {
        int records = 3;
        int firstResult = (page - 1) * records;

        List<Post> posts = postService.scrollPosts(firstResult, records);
        if (posts == null) {
            return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

    @RequestMapping(value = {"/post/{id}"}, method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Post> getPost(@PathVariable("id") int id) {
        logger.info("Fetching post: {}", id);
        Post post = postService.findPostById(id);
        if (post == null) {
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

//    @RequestMapping(value = {"/createPost"}, method = RequestMethod.POST)
//    public ResponseEntity<Void> createPost(@RequestBody Post post, UriComponentsBuilder uriBuilder) {
//        logger.info("Create post: {}", post.getId());
//        postService.savePost(post);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(uriBuilder.path("/post/{id}").buildAndExpand(post.getId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

//    @RequestMapping(value = {"/updatePost/{id}"}, method = RequestMethod.PUT)
//    public ResponseEntity<Post> updatePost(@PathVariable("id") int id, @RequestBody Post post) {
//        logger.info("Updating post: {}", post.getId());
//        Post currentPost = postService.findPostById(id);
//        if (currentPost == null) {
//            logger.info("Not found post with id: {}", id);
//            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
//        }
//        currentPost.setTitle(post.getTitle());
//        currentPost.setTitle_clean(post.getTitle_clean());
//        currentPost.setAuthor_id(post.getAuthor_id());
//        currentPost.setArticle(post.getArticle());
//        currentPost.setDate_published(post.getDate_published());
//        currentPost.setStatus(post.isStatus());
//        currentPost.setComments_enabled(post.isComments_enabled());
//        currentPost.setViews(post.getViews());
//        currentPost.setLikes(post.getLikes());
//        currentPost.setImage_uri(post.getImage_uri());
//        return new ResponseEntity<Post>(currentPost, HttpStatus.OK);
//    }

    /**
     * Delete post by title
     * @param title
     * @return
     */
    @RequestMapping(value = {"/delete/{title}"}, method = RequestMethod.DELETE)
    public ResponseEntity<Post> deletePost(@PathVariable("title") String title) {
        logger.info("Fetching & Deleting post: {}", title);
        Post post = postService.findPostBytitle(title);
        if (post == null) {
            logger.info("Unable to delete. Post not found!");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        postService.deletePostByTitle(title);
        return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
    }
}
