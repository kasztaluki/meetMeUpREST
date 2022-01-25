package pl.webdevchallenge.meetmeuprest.eventApp.mapper;

import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.Event;
import pl.webdevchallenge.meetmeuprest.eventApp.dto.EventResultDto;

@Component
public class EventToEventResultDtoMapper {

    public EventResultDto map(Event event) {
        EventResultDto eventDto = new EventResultDto(
                event.getId(),
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
