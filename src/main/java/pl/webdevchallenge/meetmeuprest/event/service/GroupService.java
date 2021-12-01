package pl.webdevchallenge.meetmeuprest.event.service;

import org.springframework.stereotype.Service;
import pl.webdevchallenge.meetmeuprest.event.api.request.UpdateGroupRequest;
import pl.webdevchallenge.meetmeuprest.event.domain.Group;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupDto;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupResultDto;
import pl.webdevchallenge.meetmeuprest.event.mapper.GroupDtoToGroupMapper;
import pl.webdevchallenge.meetmeuprest.event.mapper.GroupToGroupResultDtoMapper;
import pl.webdevchallenge.meetmeuprest.event.repository.GroupRepository;
import pl.webdevchallenge.meetmeuprest.event.support.exception.EventExceptionSupplier;

import java.util.List;
import java.util.stream.Collectors;

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


    public GroupResultDto create(GroupDto groupDto) {
        Group group = groupRepository.save(groupDtoToGroupMapper.map(groupDto));
        return groupToGroupResultDtoMapper.map(group);
    }

    public GroupResultDto find(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(EventExceptionSupplier.itemNotFound(id));
        return groupToGroupResultDtoMapper.map(group);
    }

    public List<GroupResultDto> findAll() {
        return groupRepository.findAll().stream().map(groupToGroupResultDtoMapper::mapList).collect(Collectors.toList());
    }

    public GroupResultDto update(Long id, UpdateGroupRequest updateGroupRequest) {
        Group group = groupRepository.findById(id).orElseThrow(EventExceptionSupplier.itemNotFound(id));
        groupRepository.save(groupDtoToGroupMapper.map(group, updateGroupRequest));
        return groupToGroupResultDtoMapper.map(group);
    }

}
