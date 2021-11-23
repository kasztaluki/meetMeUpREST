package pl.webdevchallenge.meetmeuprest.event.service;

import org.springframework.stereotype.Service;
import pl.webdevchallenge.meetmeuprest.event.domain.User;
import pl.webdevchallenge.meetmeuprest.event.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createNewUsers(){
        User user1 = new User("Mietek", "Mieczysław", "mietek@gmail.com", "Mietek1234&");
        userRepository.save(user1);
        User user2 = new User("Zdzisław", "Duda", "dudek@gmail.com", "jansobau767");
        userRepository.save(user2);
        User user3 = new User("Wiesław", "Wszywka", "wszywka.w@wp.pl", " oihasbdcsa90");
        userRepository.save(user3);
    }
}
