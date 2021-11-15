package pl.webdevchallenge.meetmeuprest.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webdevchallenge.meetmeuprest.event.domain.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
}
