package pl.webdevchallenge.meetmeuprest.event.service;

import org.springframework.stereotype.Service;
import pl.webdevchallenge.meetmeuprest.event.api.request.EventRequest;
import pl.webdevchallenge.meetmeuprest.event.api.request.UpdateEventRequest;
import pl.webdevchallenge.meetmeuprest.event.api.response.ItemResponse;
import pl.webdevchallenge.meetmeuprest.event.domain.Event;
import pl.webdevchallenge.meetmeuprest.event.dto.EventDto;
import pl.webdevchallenge.meetmeuprest.event.repository.EventRepository;
import pl.webdevchallenge.meetmeuprest.event.support.EventMapper;
import pl.webdevchallenge.meetmeuprest.event.support.exception.EventExceptionSupplier;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;

    private final EventMapper eventMapper;

    public EventService(EventRepository eventRepository, EventMapper eventMapper) {

        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public ItemResponse create(EventRequest eventRequest) {

        Event event = eventRepository.save(eventMapper.toItem(eventRequest));
        return eventMapper.toItemResponse(event);
    }


    public ItemResponse find(Long id) {

        Event event = eventRepository.findById(id).orElseThrow(EventExceptionSupplier.itemNotFound(id));
        return eventMapper.toItemResponse(event);
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

    public List<ItemResponse> findAll() {
        return eventRepository.findAll().stream().map(eventMapper::toItemResponse).collect(Collectors.toList());
    }

    public void delete(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(EventExceptionSupplier.itemNotFound(id));
        eventRepository.deleteById(event.getId());
    }
}
