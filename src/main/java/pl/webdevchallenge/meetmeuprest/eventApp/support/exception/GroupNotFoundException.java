package pl.webdevchallenge.meetmeuprest.eventApp.support.exception;

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(Long id) {
        super(String.format("Group with id no. %d not fund. Please try again.", id));
    }
}
