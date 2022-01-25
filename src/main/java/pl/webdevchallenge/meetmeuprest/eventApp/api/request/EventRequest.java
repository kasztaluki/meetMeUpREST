package pl.webdevchallenge.meetmeuprest.eventApp.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class EventRequest {

    private final String name;

    @JsonCreator
    public EventRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
