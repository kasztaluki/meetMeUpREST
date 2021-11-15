package pl.webdevchallenge.meetmeuprest.event.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupDto;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupResultDto;
import pl.webdevchallenge.meetmeuprest.event.service.GroupService;

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
    public ResponseEntity<GroupResultDto> create(@RequestBody GroupDto groupRequest) {
        GroupResultDto groupResultDto = groupService.create(groupRequest);
        return new ResponseEntity<>(groupResultDto, HttpStatus.CREATED);
    }

}
