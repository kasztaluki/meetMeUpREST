package pl.webdevchallenge.meetmeuprest.eventApp.dto;

import java.util.Date;

public class EventDto {

    private String name;
    private String place;
    private int numberOfPersons;
    private String sportsCategory;
    private Date eventStartDate;
    private long eventStartTime;
    private int duration;
    private String groupCategory;
    private String eventCategory;

    public EventDto(String name, String place, int numberOfPersons,
                    String sportsCategory, Date eventStartDate, long eventStartTime, int duration, String groupCategory, String eventCategory) {
        this.name = name;
        this.place = place;
        this.numberOfPersons = numberOfPersons;
        this.sportsCategory = sportsCategory;
        this.eventStartDate = eventStartDate;
        this.eventStartTime = eventStartTime;
        this.duration = duration;
        this.groupCategory = groupCategory;
        this.eventCategory = eventCategory;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public int getNumberOfPersons() {
        return numberOfPersons;
    }

    public String getSportsCategory() {
        return sportsCategory;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public long getEventStartTime() {
        return eventStartTime;
    }

    public int getDuration() {
        return duration;
    }

    public String getGroupCategory() {
        return groupCategory;
    }

    public String getEventCategory() {
        return eventCategory;
    }

}
