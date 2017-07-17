package com.megafyk.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "blog_post")
public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "title_clean")
    private String title_clean;

    @Column(name = "article")
    private String article;

    @Column(name = "author_id")
    private Integer author_id;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "comments_enabled")
    private Boolean comments_enabled;

    @Column(name = "views")
    private Integer views;

    @Column(name = "likes")
    private Integer likes;

    @Column(name = "image_uri")
    private String image_uri;

    @Column(name = "date_published")
    private Timestamp date_published;

//    @NotEmpty
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "blog_post_blog_tag",
//            joinColumns = {@JoinColumn(name = "post_id")},
//            inverseJoinColumns = {@JoinColumn(name = "post_tag_id")})
//    private Set<PostTag> postTag = new HashSet<PostTag>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_clean() {
        return title_clean;
    }

    public void setTitle_clean(String title_clean) {
        this.title_clean = title_clean;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public Timestamp getDate_published() {
        return date_published;
    }

    public void setDate_published(Timestamp date_published) {
        this.date_published = date_published;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean isComments_enabled() {
        return comments_enabled;
    }

    public void setComments_enabled(Boolean comments_enabled) {
        this.comments_enabled = comments_enabled;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getImage_uri() {
        return image_uri;
    }

    public void setImage_uri(String image_uri) {
        this.image_uri = image_uri;
    }

//    public Set<PostTag> getPostTag() {
//        return postTag;
//    }
//
//    public void setPostTag(Set<PostTag> postTag) {
//        this.postTag = postTag;
//    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Post))
            return false;
        Post other = (Post) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Post [id=" + id + ", title=" + title + ", title_clean=" + title_clean
                + ", article=" + article + ", author_id=" + author_id
                + ", date_published=" + date_published + ", status=" + status
                + ", comments_enabled=" + comments_enabled + ", views=" + views
                + ", likes=" + likes + ", image_uri=" + image_uri + "]";
    }
}
