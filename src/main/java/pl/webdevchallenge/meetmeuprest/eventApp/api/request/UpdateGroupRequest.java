package pl.webdevchallenge.meetmeuprest.eventApp.api.request;

import pl.webdevchallenge.meetmeuprest.eventApp.dto.GroupDto;

public class UpdateGroupRequest extends GroupDto {

    private final Long id;

    public UpdateGroupRequest(Long userId, Long eventId, String groupName, String groupCategory, String place, Long id) {
        super(userId, eventId, groupName, groupCategory, place);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
