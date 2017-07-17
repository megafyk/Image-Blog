package com.megafyk.dao;

import com.megafyk.model.Post;
import org.hibernate.Criteria;
import org.hibernate.ScrollableResults;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postDao")
public class PostDaoImpl extends AbstractDao<Integer, Post> implements PostDao {

    static final Logger logger = LoggerFactory.getLogger(PostDaoImpl.class);

    public Post findPostById(int id) {
        Post post = getByKey(id);
//        if(post==null){
//            Hibernate.initialize(post.getPostTag());
//        }
        return post;
    }

    public Post findPostByAuthor(String author) {
        return null;
    }

    public Post findPostByTag(String tag) {
        logger.info("Tag: {}", tag);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("tag", tag));
        Post post = (Post) crit.uniqueResult();
//        if (post != null) {
//            Hibernate.initialize(post.getPostTag());
//        }
        return post;
    }

    public Post findPostByTitle(String title) {
        logger.info("Title : {}", title);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("title", title));
        Post post = (Post) crit.uniqueResult();
        return post;
    }

    public void savePost(Post post) {
        persist(post);
    }

    public void deletePostByTitle(String title) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("title", title));
        Post post = (Post) crit.uniqueResult();
        delete(post);
    }

    @SuppressWarnings("unchecked")
    public List<Post> findAllPosts() {
        Criteria criteria = createEntityCriteria().addOrder(Order.desc("date_published"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Post> posts = (List<Post>) criteria.list();
        return posts;
    }



    public List<Post> scrollPosts(int firstResult, int maxResults) {
        Criteria criteria = createEntityCriteria().addOrder(Order.desc("date_published"));;
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        criteria.setFirstResult(firstResult);
        criteria.setMaxResults(maxResults);
        List<Post> posts = (List<Post>) criteria.list();
        return posts;
    }

    public int getTotalRecords(){
        int totalRecords = 0;
        Criteria criteria = createEntityCriteria();
        ScrollableResults scrollableResults = criteria.scroll();
        scrollableResults.last();
        totalRecords=scrollableResults.getRowNumber()+1;
        scrollableResults.close();
        return totalRecords;
    }
}
