package pl.webdevchallenge.meetmeuprest.event.domain;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.event.util.GroupCategory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Entity(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String groupName;
    private GroupCategory groupCategory;

    @Nullable
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "group_users", joinColumns = { @JoinColumn(name = "group_id")},
            inverseJoinColumns = { @JoinColumn(name = "user_id")})
    private List<User> groupUsers = new ArrayList<User>();

    @Nullable
    @OneToMany(mappedBy = "group", cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Event> groupEvent = new ArrayList<Event>();

    public Group(String groupName, GroupCategory groupCategory, User groupUsers, Event groupEvent) {
        this.groupName = groupName;
        this.groupCategory = groupCategory;
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
