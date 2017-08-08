package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController()
public class LoginController {

    private UserRepository repository;

    @Autowired
    public LoginController(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/login", method = POST)
    public UserDTO login(@RequestBody Credentials credentials) {
        User user = repository.findByUsernameAndPassword(
                credentials.getUsername(), credentials.getPassword());
        if (user != null)
            return UserDTO.fromUser(user);
        return null;
    }

}
