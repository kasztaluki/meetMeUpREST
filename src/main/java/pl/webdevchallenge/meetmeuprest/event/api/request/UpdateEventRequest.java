package pl.webdevchallenge.meetmeuprest.event.api.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UpdateEventRequest extends EventRequest {

    private final Long id;

    @JsonCreator
    public UpdateEventRequest(String name, Long id) {
        super(name);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
