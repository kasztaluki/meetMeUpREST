package pl.webdevchallenge.meetmeuprest.login.service;

import pl.webdevchallenge.meetmeuprest.login.dto.response.SecurityResponseDto;

import java.security.Principal;

public interface SecurityService {

    SecurityResponseDto createSecurityInfo(Principal principal);

}
