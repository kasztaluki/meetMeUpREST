package pl.webdevchallenge.meetmeuprest.eventApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.User;

public interface UserEventRepository extends JpaRepository<User, Long> {
}
