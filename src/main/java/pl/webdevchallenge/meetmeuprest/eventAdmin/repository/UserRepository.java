package pl.webdevchallenge.meetmeuprest.eventAdmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.User;

@Repository("EventAdmin user repository")
public interface UserRepository extends JpaRepository<User, Long> {
}
