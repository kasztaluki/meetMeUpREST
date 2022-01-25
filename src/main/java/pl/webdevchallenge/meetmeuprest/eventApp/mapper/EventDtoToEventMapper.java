package pl.webdevchallenge.meetmeuprest.eventApp.mapper;

import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.eventApp.api.request.UpdateEventRequest;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.Event;
import pl.webdevchallenge.meetmeuprest.eventApp.dto.EventDto;
import pl.webdevchallenge.meetmeuprest.eventApp.util.EventCategory;
import pl.webdevchallenge.meetmeuprest.eventApp.util.GroupCategory;

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

    public Event map(Event event, UpdateEventRequest updateEventRequest) {
        event.setName(updateEventRequest.getName());
        event.setPlace(updateEventRequest.getPlace());
        event.setNumberOfPersons(updateEventRequest.getNumberOfPersons());
        event.setSportsCategory(updateEventRequest.getSportsCategory());
        event.setEventStartDate(updateEventRequest.getEventStartDate());
        event.setEventStartTime(updateEventRequest.getEventStartTime());
        event.setDuration(updateEventRequest.getDuration());
        event.setGroupCategory(setGroupCategory(updateEventRequest));
        event.setEventCategory(setEventCategory(updateEventRequest));
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
        else if (dto.getGroupCategory().toLowerCase().contains("ind"))
            return GroupCategory.NO_GROUP;
        else return GroupCategory.UNKNOWN;
    }

    //Przypisanie z enuma
//    private EventCategory setEventCategory(UpdateEventRequest dto) {
//        if (dto.getEventCategory().toLowerCase().contains("ind")) {
//            return EventCategory.INDIVIDUAL;
//        }
//        else if (dto.getEventCategory().toLowerCase().contains("few")) {
//            return EventCategory.MAX_FEW_PEOPLE;
//        }
//        else if (dto.getEventCategory().toLowerCase().contains("group")) {
//            return EventCategory.GROUP;
//        }
//        else if (dto.getEventCategory().toLowerCase().contains("matter")) {
//            return EventCategory.DOESNT_MATTER;
//        }
//        else {return EventCategory.UNKNOWN;}
//    }
//
//    private GroupCategory setGroupCategory(UpdateEventRequest dto) {
//        if (dto.getGroupCategory().toLowerCase().contains("friend"))
//            return GroupCategory.FRIENDSGROUP;
//        else if (dto.getGroupCategory().toLowerCase().contains("group"))
//            return GroupCategory.EVENTGROUP;
//        else if (dto.getGroupCategory().toLowerCase().contains( "ind"))
//            return GroupCategory.NO_GROUP;
//        else return GroupCategory.UNKNOWN;
//    }

    private String setSportsCategory(EventDto dto) {

        return dto.getSportsCategory();
    }

}
