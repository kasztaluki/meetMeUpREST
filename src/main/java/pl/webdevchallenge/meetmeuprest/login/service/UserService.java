package pl.webdevchallenge.meetmeuprest.login.service;

import pl.webdevchallenge.meetmeuprest.eventApp.domain.User;

public interface UserService {

    void save(User user) throws Exception;
}
