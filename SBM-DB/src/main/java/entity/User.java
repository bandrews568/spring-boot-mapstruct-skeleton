package entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Set;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;
    private String firstName;
    private String lastName;

    @NotNull
    private String email;
    private String phoneNumber;

    @CreationTimestamp
    @GeneratedValue
    private Timestamp joined;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "all_followers", joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    private Set<User> followerSet;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "all_followers", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "follower_id")})
    private Set<User> followingSet;





    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Timestamp getJoined() {
        return joined;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJoined(Timestamp joined) {
        this.joined = joined;
    }

    public Set<User> getFollowerSet() {
        return followerSet;
    }

    public void removeFromFollowers(User user) {
        this.followerSet.remove(user);
    }

    public void setFollowerSet(User followerSet) {
        this.followerSet.add(followerSet);
    }
}
