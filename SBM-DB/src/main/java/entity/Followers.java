package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Followers {

    @Id
    @GeneratedValue
    private Long id;
    private Set<String> followers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<String> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> users) {
        for (User user : users) {
            followers.add(user.getUsername());
        }
    }
}
