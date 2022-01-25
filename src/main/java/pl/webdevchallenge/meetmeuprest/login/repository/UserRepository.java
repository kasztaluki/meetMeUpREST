package pl.webdevchallenge.meetmeuprest.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.User;

public interface UserRepository  extends JpaRepository<User, Long> {
}
