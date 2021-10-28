package pl.webdevchallenge.meetmeuprest.event.domain;

import pl.webdevchallenge.meetmeuprest.event.util.EventCategory;
import pl.webdevchallenge.meetmeuprest.event.util.GroupCategory;

import javax.persistence.*;
import java.time.LocalDate;
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

    private LocalDate createDate;
    private Date eventStartDate;
    private long eventStartTime;
    private int duration;

    @Enumerated(EnumType.STRING)
    private GroupCategory groupCategory;
    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;


    public Event(String name, String place, int numberOfPersons, String sportsCategory, Date eventStartDate,
                 long eventStartTime, int duration, GroupCategory groupCategory, EventCategory eventCategory) {
        this.id = random();
        this.name = name;
        this.place = place;
        this.numberOfPersons = numberOfPersons;
        this.sportsCategory = sportsCategory;
        this.createDate = LocalDate.now();
        this.eventStartDate = eventStartDate;
        this.eventStartTime = eventStartTime;
        this.duration = duration;
        this.groupCategory = groupCategory;
        this.eventCategory = eventCategory;
    }

    public Event() {

    }
    private long random() {
        double i = Math.random() * 10;
        Math.round(i);
        return (long) i;
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

}
