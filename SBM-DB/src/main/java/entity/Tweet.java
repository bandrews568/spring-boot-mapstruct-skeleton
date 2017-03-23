package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Tweet {

    @Id
    @GeneratedValue
    @NotNull
    private Integer id;

    @NotNull
    private String author;

    @CreationTimestamp
    @GeneratedValue
    private Timestamp posted;
    private String content;
    private String inReplyTo;
    private String repostOf;

    @ElementCollection
    private List<String> hashtags;

    @OneToMany
    private List<User> likers;

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public void addLiker(User user) {
        if (!likers.isEmpty()) {
            likers.add(user);
        }
    }

    public List<User> getLikers() {
        return likers;
    }

    public void setLikers(List<User> likers) {
        this.likers = likers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getPosted() {
        return posted;
    }

    public void setPosted(Timestamp posted) {
        this.posted = posted;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public String getRepostOf() {
        return repostOf;
    }

    public void setRepostOf(String repostOf) {
        this.repostOf = repostOf;
    }
}
