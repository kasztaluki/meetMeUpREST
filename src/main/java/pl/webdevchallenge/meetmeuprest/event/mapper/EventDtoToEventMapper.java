package pl.webdevchallenge.meetmeuprest.event.mapper;

import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.event.domain.Event;
import pl.webdevchallenge.meetmeuprest.event.dto.EventDto;
import pl.webdevchallenge.meetmeuprest.event.util.EventCategory;
import pl.webdevchallenge.meetmeuprest.event.util.GroupCategory;

@Component
public class EventDtoToEventMapper {

    public EventDtoToEventMapper() {}

    public Event map(EventDto dto) {
        Event event = new Event();

        event.setName(dto.getName());
        event.setPlace(dto.getPlace());
        event.setNumberOfPersons(dto.getNumberOfPersons());
        event.setSportsCategory(setSportsCategory(dto));
        event.setEventStartDate(dto.getEventStartDate());
        event.setEventStartTime(dto.getEventStartTime());
        event.setDuration(dto.getDuration());
        event.setGroupCategory(setGroupCategory(dto));
        event.setEventCategory(setEventCategory(dto));

        return event;
    }

    //Przypisanie z enuma
    private EventCategory setEventCategory(EventDto dto) {
        if (dto.getEventCategory().toLowerCase().contains("ind")) {
            return EventCategory.INDIVIDUAL;
        }
        else if (dto.getEventCategory().toLowerCase().contains("few")) {
            return EventCategory.MAX_FEW_PEOPLE;
        }
        else if (dto.getEventCategory().toLowerCase().contains("group")) {
            return EventCategory.GROUP;
        }
        else if (dto.getEventCategory().toLowerCase().contains("matter")) {
            return EventCategory.DOESNT_MATTER;
        }
        else {return EventCategory.UNKNOWN;}
    }

    private GroupCategory setGroupCategory(EventDto dto) {
        if (dto.getGroupCategory().toLowerCase().contains("friend"))
            return GroupCategory.FRIENDSGROUP;
        else if (dto.getGroupCategory().toLowerCase().contains("group"))
                return GroupCategory.EVENTGROUP;
        else if (dto.getGroupCategory().toLowerCase().contains( "ind"))
            return GroupCategory.NO_GROUP;
        else return GroupCategory.UNKNOWN;
    }

    private String setSportsCategory(EventDto dto) {

        return dto.getSportsCategory();
    }

}
