package pl.webdevchallenge.meetmeuprest.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.webdevchallenge.meetmeuprest.login.dto.response.SecurityResponseDto;

import java.security.Principal;

@Service
public class SecurityServiceImpl implements SecurityService {



    @Override
    public SecurityResponseDto createSecurityInfo(Principal principal) {
        return null;
    }
}
