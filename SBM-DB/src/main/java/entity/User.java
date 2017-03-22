package entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.SQLData;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue
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
    private Timestamp joined;

    @OneToMany(mappedBy = "followers")
    private Set<String> followers;


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

    public void setJoined(Long joined) {
        this.joined = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
