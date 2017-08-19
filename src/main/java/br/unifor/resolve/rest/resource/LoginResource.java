package br.unifor.resolve.rest.resource;

import br.unifor.resolve.rest.dto.Credentials;
import br.unifor.resolve.rest.entity.User;
import br.unifor.resolve.rest.dto.UserDetailedDTO;
import br.unifor.resolve.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
public class LoginResource {

    private UserRepository repository;

    @Autowired
    public LoginResource(UserRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/login", method = POST)
    public UserDetailedDTO login(@RequestBody Credentials credentials) {
        User user = repository.findByUsernameAndPassword(
                credentials.getUsername(), credentials.getPassword());
        if (user != null)
            return UserDetailedDTO.fromUser(user);
        return null;
    }

}
