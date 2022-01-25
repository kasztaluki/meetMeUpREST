package pl.webdevchallenge.meetmeuprest.eventApp.domain;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.eventApp.util.GroupCategory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Entity(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String groupName;
    @Enumerated(EnumType.STRING)
    private GroupCategory groupCategory;
    private String place;

    @Nullable
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "group_users", joinColumns = { @JoinColumn(name = "group_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")})
    private List<User> groupUsers = new ArrayList<User>();

    @Nullable
    @OneToMany(mappedBy = "group", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Event> groupEvent = new ArrayList<Event>();

    public Group(String groupName, GroupCategory groupCategory, String place, User groupUsers, Event groupEvent) {
        this.groupName = groupName;
        this.groupCategory = groupCategory;
        this.place = place;
        this.groupUsers.add(groupUsers);
        this.groupEvent.add(groupEvent);
    }

    public Group() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public GroupCategory getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(GroupCategory groupCategory) {
        this.groupCategory = groupCategory;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<User> getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(User groupUsers) {
        this.groupUsers.add(groupUsers);
    }

    public List<Event> getGroupEvent() {
        return groupEvent;
    }

    public void setGroupEvent(Event groupEvent) {
        this.groupEvent.add(groupEvent);
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }

}