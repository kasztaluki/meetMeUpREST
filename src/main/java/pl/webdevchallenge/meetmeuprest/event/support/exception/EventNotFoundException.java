package pl.webdevchallenge.meetmeuprest.event.support.exception;

public class EventNotFoundException extends RuntimeException {

    public EventNotFoundException(Long id) {
        super(String.format("Event with id no. %d not fund. Please try again.", id));
    }
}
