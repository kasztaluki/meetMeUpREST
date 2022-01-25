package pl.webdevchallenge.meetmeuprest.eventAdmin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.webdevchallenge.meetmeuprest.eventAdmin.dto.request.UserRequestDTO;
import pl.webdevchallenge.meetmeuprest.eventAdmin.dto.response.UserResponseDTO;
import pl.webdevchallenge.meetmeuprest.eventAdmin.repository.UserRepository;
import pl.webdevchallenge.meetmeuprest.eventApp.component.CurrentUser;
import pl.webdevchallenge.meetmeuprest.eventApp.domain.User;

import java.util.function.Supplier;

@Service("EventAdminUserServiceImpl")
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    private CurrentUser currentUser;

    //hash decoder variable
    //private Hash = hash;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        super();
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void createNewUser(UserRequestDTO userRequestDTO) throws Exception {

        User user = new User();
        //temporary - hash decoder to implement!!!
        user.setPassword(userRequestDTO.getPassword());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setProfileNick(userRequestDTO.getProfileNick());
        user.setEmail(userRequestDTO.getMail());
        user.setActiveUser(true);

        userRepository.save(user);
    }

    @Override
    public void updateCurrentUser(UserRequestDTO userRequestDTO) throws Exception {

        User user = userRepository.findById(currentUser.getId()).orElseThrow(userNotFound());
    }

    @Override
    public UserResponseDTO getCurrentUser() {
        return null;
    }

    private Supplier<? extends RuntimeException> userNotFound() {
        return () -> new RuntimeException("User not found");
    }
}
