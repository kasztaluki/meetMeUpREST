package pl.webdevchallenge.meetmeuprest.eventApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
