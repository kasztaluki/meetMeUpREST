package pl.webdevchallenge.meetmeuprest.eventApp.support.exception;

import java.util.function.Supplier;

public class EventExceptionSupplier {

    public static Supplier<EventNotFoundException> eventNotFound(Long id) {
        return () -> new EventNotFoundException(id);
    }
}
