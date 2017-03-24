package entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "following")
public class Following {

    @Id
    @GeneratedValue
    @Column(name = "follower_id")
    private Long id;

    @ManyToMany
    private Set<User> following;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void setFollowing(Set<User> followers) {
        this.following = followers;
    }
}
