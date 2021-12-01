package pl.webdevchallenge.meetmeuprest.event.api.request;

import pl.webdevchallenge.meetmeuprest.event.dto.GroupDto;

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
