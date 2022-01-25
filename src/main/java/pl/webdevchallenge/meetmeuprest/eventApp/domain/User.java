package pl.webdevchallenge.meetmeuprest.eventApp.domain;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;

import javax.persistence.*;
import java.util.*;

@Component
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String profileNick;
    private String email;
    private String password;
    private String token;
    private Date tokenTime;
    private boolean activeUser;

    @Nullable
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "group_users", joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "group_id")})
    private Set<Group> group = new HashSet<>();

    @Nullable
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "event_users", joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "event_id")})
    private Set<Event> event = new HashSet<>();

    public User() {}

    public User(String firstName, String lastName, String profileNick, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileNick = profileNick;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    public String getPassword() {
        return password;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Group> getGroup() {
        return group;
    }

    public void setGroup(Set<Group> group) {
        this.group = group;
    }

    public Set<Event> getEvent() {
        return event;
    }

    public void setEvent(Set<Event> event) {
        this.event = event;
    }

    public String getProfileNick() {
        return profileNick;
    }

    public void setProfileNick(String profileNick) {
        this.profileNick = profileNick;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(Date tokenTime) {
        this.tokenTime = tokenTime;
    }

    public boolean isActiveUser() {
        return activeUser;
    }

    public void setActiveUser(boolean activeUser) {
        this.activeUser = activeUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + email +
                '}';
    }
}
