package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

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
