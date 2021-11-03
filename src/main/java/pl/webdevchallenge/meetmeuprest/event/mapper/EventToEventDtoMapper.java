package pl.webdevchallenge.meetmeuprest.event.mapper;

import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.event.domain.Event;
import pl.webdevchallenge.meetmeuprest.event.dto.EventDto;

@Component
public class EventToEventDtoMapper {

    public EventDto map(Event event) {
        EventDto eventDto = new EventDto(
                event.getName(),
                event.getPlace(),
                event.getNumberOfPersons(),
                event.getSportsCategory(),
                event.getEventStartDate(),
                event.getEventStartTime(),
                event.getDuration(),
                event.getGroupCategory().toString(),
                event.getEventCategory().toString()
        );
        return eventDto;
    }
}
