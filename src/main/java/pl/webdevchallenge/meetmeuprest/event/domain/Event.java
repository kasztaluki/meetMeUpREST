package pl.webdevchallenge.meetmeuprest.event.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity(name = "events")
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date startDate;
    private long startTime;
    private int duration;

    public Event(String name, int duration) {
        this.id = random();
        this.name = name;
        this.startDate = new Date();
        this.startTime = getStartDate().getTime();
        this.duration = duration;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
