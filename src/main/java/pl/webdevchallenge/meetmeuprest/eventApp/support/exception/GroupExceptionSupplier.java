package pl.webdevchallenge.meetmeuprest.eventApp.support.exception;

import java.util.function.Supplier;

public class GroupExceptionSupplier {

    public static Supplier<GroupNotFoundException> groupNotFound(Long id) {
        return () -> new GroupNotFoundException(id);
    }
}
