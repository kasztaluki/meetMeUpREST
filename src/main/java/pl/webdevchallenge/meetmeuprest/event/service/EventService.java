package pl.webdevchallenge.meetmeuprest.event.service;

import org.springframework.stereotype.Service;
import pl.webdevchallenge.meetmeuprest.event.api.request.UpdateEventRequest;
import pl.webdevchallenge.meetmeuprest.event.domain.Event;
import pl.webdevchallenge.meetmeuprest.event.domain.User;
import pl.webdevchallenge.meetmeuprest.event.dto.EventDto;
import pl.webdevchallenge.meetmeuprest.event.dto.EventResultDto;
import pl.webdevchallenge.meetmeuprest.event.mapper.EventDtoToEventMapper;
import pl.webdevchallenge.meetmeuprest.event.mapper.EventToEventResultDtoMapper;
import pl.webdevchallenge.meetmeuprest.event.repository.EventRepository;
import pl.webdevchallenge.meetmeuprest.event.support.exception.EventExceptionSupplier;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventDtoToEventMapper eventDtoToEventMapper;
    private final EventToEventResultDtoMapper eventToEventResultDtoMapper;

    public EventService(EventRepository eventRepository, EventDtoToEventMapper eventDtoToEventMapper,
                        EventToEventResultDtoMapper eventToEventResultDtoMapper) {

        this.eventRepository = eventRepository;
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

    public EventResultDto update(UpdateEventRequest updateEventRequest) {
        Event event = eventRepository.findById(updateEventRequest.getId()).orElseThrow(EventExceptionSupplier.itemNotFound(updateEventRequest.getId()));
        eventRepository.save(eventDtoToEventMapper.map(event, updateEventRequest));
        return eventToEventResultDtoMapper.map(event);
    }

    public EventResultDto updateAlternativeVersion(Long id, UpdateEventRequest updateEventRequest) {
        Event event = eventRepository.findById(id).orElseThrow(EventExceptionSupplier.itemNotFound(updateEventRequest.getId()));
        eventRepository.save(eventDtoToEventMapper.map(event,updateEventRequest));
        return eventToEventResultDtoMapper.map(event);
    }

    public void delete(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(EventExceptionSupplier.itemNotFound(id));
        eventRepository.deleteById(event.getId());
    }
}
