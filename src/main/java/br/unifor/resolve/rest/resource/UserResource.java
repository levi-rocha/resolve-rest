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

    @RequestMapping(value = "/{id}", method = GET)
    public UserDetailedDTO findById(
            @PathVariable long id) {
        return UserDetailedDTO.fromUser(
                userRepository.findOne(id));
    }

    @RequestMapping(value = "/verifyEmailTaken", method = GET)
    public boolean emailIsTaken(@RequestParam("email") String email) {
        return userRepository.existsByEmail(email);
    }

    @RequestMapping(method = POST)
    public UserDetailedDTO insert(@RequestBody User user) {
        return UserDetailedDTO.fromUser(userRepository.save(user));
    }

    @RequestMapping(value = "/{id}", method = PATCH)
    public UserDetailedDTO update(@RequestBody UserUpdateFields user,
                                  @PathVariable long id) {
        User found = userRepository.findOne(id);
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

    @RequestMapping(value = "/{id}", method = DELETE)
    public Long delete(@PathVariable long id) {
        return userRepository.deleteById(id);
    }

}
