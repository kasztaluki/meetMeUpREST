package pl.webdevchallenge.meetmeuprest.event.dto;

import pl.webdevchallenge.meetmeuprest.event.util.EventCategory;
import pl.webdevchallenge.meetmeuprest.event.util.GroupCategory;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.Date;

public class EventDto {

    private Long id;
    private String name;
    private String place;
    private int numberOfPersons;
    private String sportsCategory;
    private Date eventStartDate;
    private long eventStartTime;
    private int duration;
    private GroupCategory groupCategory;
    private EventCategory eventCategory;

    public EventDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
