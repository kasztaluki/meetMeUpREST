package pl.webdevchallenge.meetmeuprest.login.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.User;
import pl.webdevchallenge.meetmeuprest.login.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void save(User user) throws Exception {
        userRepository.save(user);
    }
}
