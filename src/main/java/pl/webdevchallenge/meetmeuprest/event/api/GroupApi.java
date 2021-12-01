package pl.webdevchallenge.meetmeuprest.event.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.webdevchallenge.meetmeuprest.event.api.request.UpdateGroupRequest;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupDto;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupResultDto;
import pl.webdevchallenge.meetmeuprest.event.service.GroupService;

import java.util.List;

@RestController
@Api(tags = "Groups")
@RequestMapping("/api/groups")
public class GroupApi {
    private final GroupService groupService;

    public GroupApi(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    @ApiOperation("Create group")
    public ResponseEntity<GroupResultDto> create(@RequestBody GroupDto groupDto) {
        GroupResultDto groupResultDto = groupService.create(groupDto);
        return new ResponseEntity<>(groupResultDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find group")
    public ResponseEntity<GroupResultDto> find(@PathVariable Long id) {
        GroupResultDto groupResultDto = groupService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(groupResultDto);
    }

    @GetMapping
    @ApiOperation("Find all groups")
    public ResponseEntity<List<GroupResultDto>> findAll() {
        List<GroupResultDto> groupResultDtos = groupService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(groupResultDtos);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update group")
    public ResponseEntity<GroupResultDto> update(@PathVariable Long id, @RequestBody UpdateGroupRequest updateGroupRequest) {
        GroupResultDto groupResultDto = groupService.update(id, updateGroupRequest);
        return ResponseEntity.status(HttpStatus.OK).body(groupResultDto);
    }



}
