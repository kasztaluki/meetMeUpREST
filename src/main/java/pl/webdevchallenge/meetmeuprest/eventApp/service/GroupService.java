package pl.webdevchallenge.meetmeuprest.eventApp.service;

import org.springframework.stereotype.Service;
import pl.webdevchallenge.meetmeuprest.eventApp.api.request.UpdateGroupRequest;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.Group;
import pl.webdevchallenge.meetmeuprest.eventApp.dto.GroupDto;
import pl.webdevchallenge.meetmeuprest.eventApp.dto.GroupResultDto;
import pl.webdevchallenge.meetmeuprest.eventApp.mapper.GroupDtoToGroupMapper;
import pl.webdevchallenge.meetmeuprest.eventApp.mapper.GroupToGroupResultDtoMapper;
import pl.webdevchallenge.meetmeuprest.eventApp.repository.GroupRepository;
import pl.webdevchallenge.meetmeuprest.eventApp.support.exception.GroupExceptionSupplier;

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
        Group group = groupRepository.findById(id).orElseThrow(GroupExceptionSupplier.groupNotFound(id));
        return groupToGroupResultDtoMapper.map(group);
    }

    public List<GroupResultDto> findAll() {
        return groupRepository.findAll().stream().map(groupToGroupResultDtoMapper::mapList).collect(Collectors.toList());
    }

    public GroupResultDto update(Long id, UpdateGroupRequest updateGroupRequest) {
        Group group = groupRepository.findById(id).orElseThrow(GroupExceptionSupplier.groupNotFound(id));
        groupRepository.save(groupDtoToGroupMapper.map(group, updateGroupRequest));
        return groupToGroupResultDtoMapper.map(group);
    }

    public void delete(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(GroupExceptionSupplier.groupNotFound(id));
        groupRepository.deleteById(group.getId());
    }
}
