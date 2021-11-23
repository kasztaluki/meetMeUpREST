package pl.webdevchallenge.meetmeuprest.event.domain;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    private long userId;
    private String login;
    private String password;

    @Nullable
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "group_users", joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "group_id")})
    private List<Group> group = new ArrayList<Group>();

    @Nullable
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH })
    @JoinTable(name = "event_users", joinColumns = { @JoinColumn(name = "user_id")},
            inverseJoinColumns = { @JoinColumn(name = "event_id")})
    private List<Event> event = new ArrayList<Event>();

    public User() {}

    public User(String name, String surname, String login, String password) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(long userId) {
        this.userId = this.getId();
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                '}';
    }
}
