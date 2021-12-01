package pl.webdevchallenge.meetmeuprest.event.dto;

public class GroupResultDto {
    private long id;
    private String groupName;
    private String groupCategory;
    private String place;
    private int numberOfUsers;

    public GroupResultDto(long id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public GroupResultDto(long id, String groupName, String groupCategory, String place, int numberOfUsers) {
        this. id = id;
        this.groupName = groupName;
        this.groupCategory = groupCategory;
        this.place = place;
        this.numberOfUsers = numberOfUsers;
    }

    public long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }
}
