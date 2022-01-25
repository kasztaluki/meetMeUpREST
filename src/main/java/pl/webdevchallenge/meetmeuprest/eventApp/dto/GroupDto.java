package pl.webdevchallenge.meetmeuprest.eventApp.dto;

public class GroupDto {

    private long userId;
    private long eventId;
    private String groupName;
    private String groupCategory;
    private String place;

    public GroupDto(Long userId, Long eventId, String groupName, String groupCategory, String place) {
        this.userId = userId;
        this.eventId = eventId;
        this.groupName = groupName;
        this.groupCategory = groupCategory;
        this.place = place;
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

    public String getPlace() {
        return place;
    }
}
