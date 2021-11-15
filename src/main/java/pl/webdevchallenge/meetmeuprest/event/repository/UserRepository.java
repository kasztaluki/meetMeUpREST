package pl.webdevchallenge.meetmeuprest.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webdevchallenge.meetmeuprest.event.domain.User;

public interface UserRepository  extends JpaRepository<User, Long> {
}
