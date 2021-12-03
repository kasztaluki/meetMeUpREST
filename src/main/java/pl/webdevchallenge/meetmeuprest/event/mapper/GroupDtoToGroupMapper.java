package pl.webdevchallenge.meetmeuprest.event.mapper;

import org.springframework.stereotype.Component;
import pl.webdevchallenge.meetmeuprest.event.api.request.UpdateGroupRequest;
import pl.webdevchallenge.meetmeuprest.event.domain.Event;
import pl.webdevchallenge.meetmeuprest.event.domain.Group;
import pl.webdevchallenge.meetmeuprest.event.domain.User;
import pl.webdevchallenge.meetmeuprest.event.dto.GroupDto;
import pl.webdevchallenge.meetmeuprest.event.repository.EventRepository;
import pl.webdevchallenge.meetmeuprest.event.repository.UserRepository;
import pl.webdevchallenge.meetmeuprest.event.support.exception.EventExceptionSupplier;
import pl.webdevchallenge.meetmeuprest.event.util.GroupCategory;

@Component
public class GroupDtoToGroupMapper {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final User user;
    private final Event event;

    public GroupDtoToGroupMapper(UserRepository userRepository, EventRepository eventRepository, User user, Event event) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.user = user;
        this.event = event;
    }

    private User getUser(Long id) {
        //to do and update user exceptions
        User user = userRepository.findById(id).orElseThrow(EventExceptionSupplier.eventNotFound(id));
        return user;
    }

    private Event getEvent(Long id) {
        Event event = eventRepository.findById(id).orElseThrow(EventExceptionSupplier.eventNotFound(id));
        return event;
    }

    public Group map(GroupDto dto) {
        Group group = new Group();

        group.setGroupUsers(getUser(dto.getUserId()));
        group.setGroupEvent(getEvent(dto.getEventId()));
        group.setGroupName(dto.getGroupName());
        group.setGroupCategory(setGroupCategory(dto));
        group.setPlace(dto.getPlace());

        return group;
    }
    public Group map(Group group, UpdateGroupRequest updateGroupRequest) {
        //dodawanie usera do listy grupy przez aktualizację - do wyciągnięcia do oddzielnej metody/mapowania
        group.setGroupUsers(getUser(updateGroupRequest.getUserId()));
        //dodawanie eventu do listy grupy przez aktualizację - do wyciągnięcia do oddzielnej metody/mapowania
        group.setGroupEvent(getEvent(updateGroupRequest.getUserId()));
        group.setGroupName(updateGroupRequest.getGroupName());
        group.setGroupCategory(setGroupCategory(updateGroupRequest));
        group.setPlace(updateGroupRequest.getPlace());

        return group;
    }

    //do poprawy / wpisania wymagań dokumentacji dla frontu
    private GroupCategory setGroupCategory(GroupDto dto) {
        if (dto.getGroupCategory().toLowerCase().contains("friend"))
            return GroupCategory.FRIENDSGROUP;
        else if (dto.getGroupCategory().toLowerCase().contains("group"))
            return GroupCategory.EVENTGROUP;
        else if (dto.getGroupCategory().toLowerCase().contains("ind"))
            return GroupCategory.NO_GROUP;
        else return GroupCategory.UNKNOWN;
    }
}
