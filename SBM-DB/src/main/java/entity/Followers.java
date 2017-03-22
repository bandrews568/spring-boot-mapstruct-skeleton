package entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "followers")
public class Followers {

    @Id
    @GeneratedValue
    @Column(name = "follower_id")
    private Long id;

    @ManyToMany
    private Set<User> followers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }
}
