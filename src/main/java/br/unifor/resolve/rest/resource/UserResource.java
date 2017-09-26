package br.unifor.resolve.rest.resource;

import br.unifor.resolve.rest.entity.User;
import br.unifor.resolve.rest.dto.UserUpdateFields;
import br.unifor.resolve.rest.dto.UserDetailedDTO;
import br.unifor.resolve.rest.dto.UserSimpleDTO;
import br.unifor.resolve.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserResource {

    private UserRepository userRepository;

    @Autowired
    public UserResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(method = GET)
    public List<UserSimpleDTO> findAllUsers(Pageable pageable) {
        List<User> data = userRepository.findAll(pageable).getContent();
        List<UserSimpleDTO> dtos = new ArrayList<>();
        for (User u : data) {
            dtos.add(UserSimpleDTO.fromUser(u));
        }
        return dtos;
    }

    @RequestMapping(value = "/{username}", method = GET)
    public UserDetailedDTO findByUsername(
            @PathVariable String username) {
        return UserDetailedDTO.fromUser(
                userRepository.findByUsername(username));
    }

    @RequestMapping(value = "/verifyEmailTaken", method = GET)
    public boolean emailIsTaken(@RequestParam("email") String email) {
        return userRepository.existsByEmail(email);
    }

    @RequestMapping(method = POST)
    public UserDetailedDTO insert(@RequestBody User user) {
        return UserDetailedDTO.fromUser(userRepository.save(user));
    }

    @RequestMapping(value = "/{username}", method = PATCH)
    public UserDetailedDTO update(@RequestBody UserUpdateFields user,
                                  @PathVariable String username) {
        User found = userRepository.findByUsername(username);
        if (found == null)
            return null;
        if (user.getUsername() != null)
            found.setUsername(user.getUsername());
        if (user.getPassword() != null)
            System.out.println(user.getPassword());
            found.setPassword(user.getPassword());
        if (user.getEmail() != null)
            found.setEmail(user.getEmail());
        if (user.getPermission() != null)
            found.setPermission(user.getPermission());
        return UserDetailedDTO.fromUser(userRepository.save(found));
    }

    @RequestMapping(value = "/{username}", method = DELETE)
    public Long delete(@PathVariable String username) {
        return userRepository.deleteByUsername(username);
    }

}
