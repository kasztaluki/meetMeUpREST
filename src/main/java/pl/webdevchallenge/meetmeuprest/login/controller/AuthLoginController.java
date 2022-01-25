package pl.webdevchallenge.meetmeuprest.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.webdevchallenge.meetmeuprest.login.service.UserService;

@RestController
@Validated
@RequestMapping("/auth")
public class AuthLoginController {

    private UserService userService;

    @Autowired
    public AuthLoginController(UserService userService) {
        this.userService = userService;
    }

    //wysłanie tokena do restartu hasła

    //zmiana hasła z użyciem tokena

    //ustalenie nowego hasła

}
