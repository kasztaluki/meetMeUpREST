package pl.webdevchallenge.meetmeuprest.event.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.webdevchallenge.meetmeuprest.event.api.request.EventRequest;
import pl.webdevchallenge.meetmeuprest.event.api.request.UpdateEventRequest;
import pl.webdevchallenge.meetmeuprest.event.api.response.ItemResponse;
import pl.webdevchallenge.meetmeuprest.event.domain.Event;
import pl.webdevchallenge.meetmeuprest.event.dto.EventDto;
import pl.webdevchallenge.meetmeuprest.event.dto.EventResultDto;
import pl.webdevchallenge.meetmeuprest.event.service.EventService;

import javax.swing.text.DateFormatter;
import java.util.Date;
import java.util.List;

@RestController
@Api (tags = "Events")
@RequestMapping("/api/events")
public class EventApi {

    private final EventService eventService;

    EventApi(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    @ApiOperation("Create event")
    public ResponseEntity<EventResultDto> create(@RequestBody EventDto eventRequest){
        EventResultDto eventResultDto = eventService.create(eventRequest);
        return new ResponseEntity<>(eventResultDto, HttpStatus.CREATED);
    }

//    @GetMapping("/new-event")
//    public Event createNew() {
//        return new Event("Gra w tenisa", 2);
//    }

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/{id}")
    @ApiOperation("Find event")
    public ResponseEntity<ItemResponse> find(@PathVariable Long id){
        ItemResponse itemResponse = eventService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @PutMapping
    @ApiOperation("Update event")
    public ResponseEntity<ItemResponse> update(@RequestBody UpdateEventRequest updateItemRequest) {
        ItemResponse itemResponse = eventService.update(updateItemRequest);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }


//    Alternatywna ścieżka - przekazanie id w parametrze ścieżki @PathVariable
    @PutMapping("/{id}")
    @ApiOperation("Alternative version update event")
    public ResponseEntity<ItemResponse> update(@PathVariable Long id, @RequestBody UpdateEventRequest updateItemRequest) {
        ItemResponse itemResponse = eventService.updateAlternativeVersion(id, updateItemRequest);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @GetMapping
    @ApiOperation("Find all events")
    public ResponseEntity<List<ItemResponse>> findAll() {
        List<ItemResponse> itemResponses = eventService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemResponses);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete event")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        eventService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
