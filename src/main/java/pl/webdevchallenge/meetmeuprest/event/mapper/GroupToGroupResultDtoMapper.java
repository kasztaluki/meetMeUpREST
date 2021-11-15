package pl.webdevchallenge.meetmeuprest.event.mapper;

import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.event.domain.Group;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupResultDto;

@Component
public class GroupToGroupResultDtoMapper {
    public GroupResultDto map(Group group) {
        GroupResultDto groupResultDto = new GroupResultDto(
                group.getId(),
                group.getGroupName()
        );
        return groupResultDto;
    }
}
