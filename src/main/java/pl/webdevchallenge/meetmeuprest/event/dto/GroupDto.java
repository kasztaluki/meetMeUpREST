package pl.webdevchallenge.meetmeuprest.event.dto;

import java.util.ArrayList;
import java.util.List;

public class GroupDto {

    private long userId;
    private long eventId;
    private String groupName;
    private String groupCategory;


    public GroupDto(Long userId, Long eventId, String groupName, String groupCategory) {
        this.userId = userId;
        this.eventId = eventId;
        this.groupName = groupName;
        this.groupCategory = groupCategory;
    }

    public long getUserId() {
        return userId;
    }

    public long getEventId() {
        return eventId;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupCategory() {
        return groupCategory;
    }
}
