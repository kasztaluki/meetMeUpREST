package pl.webdevchallenge.meetmeuprest.event.service;

import org.springframework.stereotype.Service;
import pl.webdevchallenge.meetmeuprest.event.domain.Group;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupDto;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupResultDto;
import pl.webdevchallenge.meetmeuprest.event.mapper.GroupDtoToGroupMapper;
import pl.webdevchallenge.meetmeuprest.event.mapper.GroupToGroupResultDtoMapper;
import pl.webdevchallenge.meetmeuprest.event.repository.GroupRepository;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupDtoToGroupMapper groupDtoToGroupMapper;
    private final GroupToGroupResultDtoMapper groupToGroupResultDtoMapper;

    public GroupService(GroupRepository groupRepository, GroupDtoToGroupMapper groupDtoToGroupMapper,
                        GroupToGroupResultDtoMapper groupToGroupResultDtoMapper) {
        this.groupRepository = groupRepository;
        this.groupDtoToGroupMapper = groupDtoToGroupMapper;
        this.groupToGroupResultDtoMapper = groupToGroupResultDtoMapper;
    }


    public GroupResultDto create(GroupDto groupRequest) {
        Group group = groupRepository.save(groupDtoToGroupMapper.map(groupRequest));
        return groupToGroupResultDtoMapper.map(group);
    }
}
