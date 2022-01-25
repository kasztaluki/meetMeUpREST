package pl.webdevchallenge.meetmeuprest.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
