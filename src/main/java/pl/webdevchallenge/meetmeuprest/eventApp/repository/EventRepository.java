package pl.webdevchallenge.meetmeuprest.eventApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.Event;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}
