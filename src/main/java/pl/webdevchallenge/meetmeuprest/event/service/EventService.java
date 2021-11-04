package pl.webdevchallenge.meetmeuprest.event.service;

import org.springframework.stereotype.Service;
import pl.webdevchallenge.meetmeuprest.event.api.request.UpdateEventRequest;
import pl.webdevchallenge.meetmeuprest.event.api.response.ItemResponse;
import pl.webdevchallenge.meetmeuprest.event.domain.Event;
import pl.webdevchallenge.meetmeuprest.event.dto.EventDto;
import pl.webdevchallenge.meetmeuprest.event.dto.EventResultDto;
import pl.webdevchallenge.meetmeuprest.event.mapper.EventDtoToEventMapper;
import pl.webdevchallenge.meetmeuprest.event.mapper.EventToEventResultDtoMapper;
import pl.webdevchallenge.meetmeuprest.event.repository.EventRepository;
import pl.webdevchallenge.meetmeuprest.event.support.EventMapper;
import pl.webdevchallenge.meetmeuprest.event.support.exception.EventExceptionSupplier;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventDtoToEventMapper eventDtoToEventMapper;
    private final EventToEventResultDtoMapper eventToEventResultDtoMapper;
    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper,
                        EventDtoToEventMapper eventDtoToEventMapper, EventToEventResultDtoMapper eventToEventResultDtoMapper) {

        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
        this.eventDtoToEventMapper = eventDtoToEventMapper;
        this.eventToEventResultDtoMapper = eventToEventResultDtoMapper;
    }

    public EventResultDto create(EventDto eventRequest) {

        Event event = eventRepository.save(eventDtoToEventMapper.map(eventRequest));
        return eventToEventResultDtoMapper.map(event);
    }


    public EventResultDto find(Long id) {

        Event event = eventRepository.findById(id).orElseThrow(EventExceptionSupplier.itemNotFound(id));
        return eventToEventResultDtoMapper.map(event);
    }

    public List<EventResultDto> findAll() {
        return eventRepository.findAll().stream().map(eventToEventResultDtoMapper::map).collect(Collectors.toList());
    }

    public ItemResponse update(UpdateEventRequest updateItemRequest) {

        Event event = eventRepository.findById(updateItemRequest.getId()).orElseThrow(EventExceptionSupplier.itemNotFound(updateItemRequest.getId()));
        eventRepository.save(eventMapper.toItem(event, updateItemRequest));
        return eventMapper.toItemResponse(event);
    }

    public ItemResponse updateAlternativeVersion(Long id, UpdateEventRequest updateItemRequest) {
        Event event = eventRepository.findById(id).orElseThrow(EventExceptionSupplier.itemNotFound(updateItemRequest.getId()));
        eventRepository.save(eventMapper.toItem(event,updateItemRequest));
        return eventMapper.toItemResponse(event);
    }

    public void delete(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(EventExceptionSupplier.itemNotFound(id));
        eventRepository.deleteById(event.getId());
    }
}
