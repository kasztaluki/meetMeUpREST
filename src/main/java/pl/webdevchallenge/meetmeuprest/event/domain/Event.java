package pl.webdevchallenge.meetmeuprest.event.domain;

import pl.webdevchallenge.meetmeuprest.event.util.EventCategory;
import pl.webdevchallenge.meetmeuprest.event.util.GroupCategory;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long userId;

    private String name;
    private String place;
    private int numberOfPersons;
    private String sportsCategory;

    private LocalDateTime createDate;
    private Date eventStartDate;
    private long eventStartTime;
    private int duration;

    @Enumerated(EnumType.STRING)
    private GroupCategory groupCategory;
    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;


    public Event(String name, String place, int numberOfPersons, String sportsCategory, Date eventStartDate,
                 long eventStartTime, int duration, GroupCategory groupCategory, EventCategory eventCategory) {
        this.name = name;
        this.place = place;
        this.numberOfPersons = numberOfPersons;
        this.sportsCategory = sportsCategory;
        createDate = LocalDateTime.now();
        this.eventStartDate = eventStartDate;
        this.eventStartTime = eventStartTime;
        this.duration = duration;
        this.groupCategory = groupCategory;
        this.eventCategory = eventCategory;
    }

    public Event() {
        createDate = LocalDateTime.now();
    }

    public Event(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public long getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(long eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public void setNumberOfPersons(int numberOfPersons) {
        this.numberOfPersons = numberOfPersons;
    }

    public String getSportsCategory() {
        return sportsCategory;
    }

    public void setSportsCategory(String sportsCategory) {
        this.sportsCategory = sportsCategory;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

//    public void setCreateDate(LocalDate createDate) {
//        this.createDate = createDate;
//    }

    public GroupCategory getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(GroupCategory groupCategory) {
        this.groupCategory = groupCategory;
    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }
}
