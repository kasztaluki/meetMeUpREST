package pl.webdevchallenge.meetmeuprest.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.webdevchallenge.meetmeuprest.login.dto.response.SecurityResponseDto;
import pl.webdevchallenge.meetmeuprest.login.service.SecurityService;

import java.security.Principal;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private SecurityService securityService;

    @GetMapping("/browse")
    public ResponseEntity<SecurityResponseDto> browse(Principal principal) throws Exception {

        SecurityResponseDto securityResponseDto = securityService.createSecurityInfo(principal);
        return new ResponseEntity<SecurityResponseDto>(securityResponseDto, HttpStatus.OK);
    }

}
