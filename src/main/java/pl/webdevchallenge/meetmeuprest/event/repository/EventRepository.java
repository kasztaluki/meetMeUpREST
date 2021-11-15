package pl.webdevchallenge.meetmeuprest.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.webdevchallenge.meetmeuprest.event.domain.Event;
import pl.webdevchallenge.meetmeuprest.event.domain.User;
import pl.webdevchallenge.meetmeuprest.event.dto.EventDto;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
