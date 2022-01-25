package pl.webdevchallenge.meetmeuprest.eventApp.mapper;

import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.Group;
import pl.webdevchallenge.meetmeuprest.eventApp.dto.GroupResultDto;

@Component
public class GroupToGroupResultDtoMapper {
    public GroupResultDto map(Group group) {
        GroupResultDto groupResultDto = new GroupResultDto(
                group.getId(),
                group.getGroupName()
        );
        return groupResultDto;
    }

    public GroupResultDto mapList(Group group) {
        GroupResultDto groupResultDto = new GroupResultDto(
                group.getId(),
                group.getGroupName(),
                group.getGroupCategory().toString(),
                group.getPlace(),
                //wyliczenie liczby uczestników grupy
                group.getGroupUsers().size()
        );
        return groupResultDto;
    }
}