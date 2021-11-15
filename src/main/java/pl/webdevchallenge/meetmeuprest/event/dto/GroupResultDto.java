package pl.webdevchallenge.meetmeuprest.event.dto;

public class GroupResultDto {
    private long id;
    private String groupName;

    public GroupResultDto(long id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }
}
