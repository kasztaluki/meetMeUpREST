package pl.webdevchallenge.meetmeuprest.eventApp.component;

import org.springframework.stereotype.Component;

@Component
public class CurrentUser {

    private Long id;

    private String firstName;

    private String lastName;

    private String profileNick;

    public long eventAppFakeId = 0;

    public synchronized long reset() {

        eventAppFakeId = 0;
        return eventAppFakeId;
    }

    public synchronized long increment() {return ++eventAppFakeId;}

    public synchronized long decrement() {return --eventAppFakeId;}

    public synchronized void setEventAppFakeId(Long eventAppFakeId) {
        this.eventAppFakeId = eventAppFakeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileNick() {
        return profileNick;
    }

    public void setProfileNick(String profileNick) {
        this.profileNick = profileNick;
    }
}
