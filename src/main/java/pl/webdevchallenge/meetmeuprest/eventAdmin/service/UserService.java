package pl.webdevchallenge.meetmeuprest.eventAdmin.service;

import pl.webdevchallenge.meetmeuprest.eventAdmin.dto.request.UserRequestDTO;
import pl.webdevchallenge.meetmeuprest.eventAdmin.dto.response.UserResponseDTO;

public interface UserService {

    void createNewUser(UserRequestDTO userRequestDTO) throws Exception;


    void updateCurrentUser(UserRequestDTO userRequestDTO) throws Exception;


    UserResponseDTO getCurrentUser() throws Exception;
}
