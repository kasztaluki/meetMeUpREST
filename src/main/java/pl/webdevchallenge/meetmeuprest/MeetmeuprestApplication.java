package pl.webdevchallenge.meetmeuprest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.webdevchallenge.meetmeuprest.event.domain.User;
import pl.webdevchallenge.meetmeuprest.event.service.UserService;

@SpringBootApplication
public class MeetmeuprestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetmeuprestApplication.class, args);
	}
}
