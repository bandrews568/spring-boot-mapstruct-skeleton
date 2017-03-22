package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Tweet {

    @Id
    @GeneratedValue
    @NotNull
    private Integer id;

    @NotNull
    private String author;
    private Long posted;
    private String content;
    private String inReplyTo;
    private String repostOf;

    public Tweet(String author, String content) {
        this.author = author;
        this.content = content;
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

    public Long getPosted() {
        return posted;
    }

    public void setPosted(Long posted) {
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
