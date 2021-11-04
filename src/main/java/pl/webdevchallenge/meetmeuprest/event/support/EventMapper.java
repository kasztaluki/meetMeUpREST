package pl.webdevchallenge.meetmeuprest.event.support;

import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.event.api.request.EventRequest;
import pl.webdevchallenge.meetmeuprest.event.api.request.UpdateEventRequest;
import pl.webdevchallenge.meetmeuprest.event.api.response.ItemResponse;
import pl.webdevchallenge.meetmeuprest.event.domain.Event;

@Component
public class EventMapper {

    public Event toItem(EventRequest eventRequest) {
        return new Event(eventRequest.getName());
    }

    public Event toItem(Event event, UpdateEventRequest itemRequest) {
        event.setName(itemRequest.getName());
        return event;
    }

    public Event toItem(Event event, EventRequest eventRequest) {
        event.setName(eventRequest.getName());
        return event;
    }

    public ItemResponse toItemResponse (Event event) {
        return new ItemResponse(event.getId(), event.getName());
    }
}
