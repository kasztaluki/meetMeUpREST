package pl.webdevchallenge.meetmeuprest.event.support.exception;

import java.util.function.Supplier;

public class GroupExceptionSupplier {

    public static Supplier<GroupNotFoundException> groupNotFound(Long id) {
        return () -> new GroupNotFoundException(id);
    }
}
