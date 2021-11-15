package pl.webdevchallenge.meetmeuprest.event.domain;

import pl.webdevchallenge.meetmeuprest.event.util.GroupCategory;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String groupName;
    private GroupCategory groupCategory;
    @OneToMany
    private Set<User> groupUsersList;
    @OneToMany
    private Set<Event> groupEventList;
    @ManyToOne
    private User groupUser;
    @ManyToOne
    private Event groupEvent;

    public Group(String groupName, GroupCategory groupCategory, /*, Set<User> groupUsersList, Set<Event> groupEventList*/User groupUser, Event groupEvent) {
        this.groupName = groupName;
        this.groupCategory = groupCategory;
//        this.groupUsersList = new HashSet<>(groupUsersList);
//        this.groupEventList = new HashSet<>(groupEventList);
        this.groupUser = groupUser;
        this.groupEvent = groupEvent;
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

    public Set<User> getGroupUsersList() {
        return groupUsersList;
    }

    public void setGroupUsersList(User groupUsersList) {
        this.groupUsersList.add(groupUsersList);
    }

    public Set<Event> getGroupEventList() {
        return groupEventList;
    }

    public void setGroupEventList(Event groupEventList) {
        this.groupEventList.add(groupEventList);
    }

    public User getGroupUser() {
        return groupUser;
    }

    public void setGroupUser(User groupUser) {
        this.groupUser = groupUser;
    }

    public Event getGroupEvent() {
        return groupEvent;
    }

    public void setGroupEvent(Event groupEvent) {
        this.groupEvent = groupEvent;
    }

}
