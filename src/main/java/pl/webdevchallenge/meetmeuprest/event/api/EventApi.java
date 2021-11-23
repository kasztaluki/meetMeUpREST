package pl.webdevchallenge.meetmeuprest.event.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.webdevchallenge.meetmeuprest.event.api.request.UpdateEventRequest;
import pl.webdevchallenge.meetmeuprest.event.dto.EventDto;
import pl.webdevchallenge.meetmeuprest.event.dto.EventResultDto;
import pl.webdevchallenge.meetmeuprest.event.service.EventService;
import pl.webdevchallenge.meetmeuprest.event.service.UserService;

import javax.swing.text.DateFormatter;
import java.util.Date;
import java.util.List;

@RestController
@Api (tags = "Events")
@RequestMapping("/api/events")
public class EventApi {

    private final EventService eventService;
    private final UserService userService;

    public EventApi(EventService eventService, UserService userService) {
        this.eventService = eventService;
        this.userService = userService;
    }

    @PostMapping
    @ApiOperation("Create event")
    public ResponseEntity<EventResultDto> create(@RequestBody EventDto eventRequest){
        userService.createNewUsers();
        EventResultDto eventResultDto = eventService.create(eventRequest);
        return new ResponseEntity<>(eventResultDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find event")
    public ResponseEntity<EventResultDto> find(@PathVariable Long id){
        EventResultDto eventResultDto = eventService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(eventResultDto);
    }

    @GetMapping
    @ApiOperation("Find all events")
    public ResponseEntity<List<EventResultDto>> findAll() {
        List<EventResultDto> eventResultDtos = eventService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(eventResultDtos);
    }

    @PutMapping
    @ApiOperation("Update event")
    public ResponseEntity<EventResultDto> update(@RequestBody UpdateEventRequest updateEventRequest) {
        EventResultDto eventResultDto = eventService.update(updateEventRequest);
        return ResponseEntity.status(HttpStatus.OK).body(eventResultDto);
    }


//    Alternatywna ścieżka - przekazanie id w parametrze ścieżki @PathVariable
    @PutMapping("/{id}")
    @ApiOperation("Alternative version update event")
    public ResponseEntity<EventResultDto> update(@PathVariable Long id, @RequestBody UpdateEventRequest updateEventRequest) {
        EventResultDto eventResultDto = eventService.updateAlternativeVersion(id, updateEventRequest);
        return ResponseEntity.status(HttpStatus.OK).body(eventResultDto);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete event")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
