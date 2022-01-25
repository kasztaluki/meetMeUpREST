package pl.webdevchallenge.meetmeuprest.eventApp.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import pl.webdevchallenge.meetmeuprest.eventApp.dto.EventDto;

import java.util.Date;

public class UpdateEventRequest extends EventDto {

    private final Long id;

    @JsonCreator
    public UpdateEventRequest(String name, String place, int numberOfPersons,
                              String sportsCategory, Date eventStartDate, long eventStartTime,
                              int duration, String groupCategory, String eventCategory, Long id) {
        super(name, place, numberOfPersons, sportsCategory, eventStartDate, eventStartTime, duration, groupCategory, eventCategory);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
