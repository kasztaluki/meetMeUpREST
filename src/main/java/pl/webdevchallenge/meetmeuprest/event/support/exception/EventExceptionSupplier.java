package pl.webdevchallenge.meetmeuprest.event.support.exception;

import java.util.function.Supplier;

public class EventExceptionSupplier {

    public static Supplier<EventNotFoundException> itemNotFound(Long id) {
        return () -> new EventNotFoundException(id);
    }
}
