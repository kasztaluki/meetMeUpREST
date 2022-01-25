package pl.webdevchallenge.meetmeuprest.eventAdmin.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.webdevchallenge.meetmeuprest.eventAdmin.dto.request.UserRequestDTO;
import pl.webdevchallenge.meetmeuprest.eventAdmin.dto.response.UserResponseDTO;
import pl.webdevchallenge.meetmeuprest.eventAdmin.service.UserService;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/api/eventadmin/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<Void> createNewUser(
            @Valid @RequestBody UserRequestDTO userRequestDTO) throws Exception {
        userService.createNewUser(userRequestDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/current")
    public ResponseEntity<Void> updateCurrentUser(
            @Valid @RequestBody UserRequestDTO userRequestDTO) throws Exception {
        userService.updateCurrentUser(userRequestDTO);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/current")
    public ResponseEntity<UserResponseDTO> getCurrentUser() throws Exception {

        UserResponseDTO userResponseDTO = userService.getCurrentUser();
        return new ResponseEntity<UserResponseDTO>(userResponseDTO, HttpStatus.OK);
    }

}
