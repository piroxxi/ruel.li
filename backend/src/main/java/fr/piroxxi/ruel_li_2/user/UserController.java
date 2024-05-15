package fr.piroxxi.ruel_li_2.user;

import fr.piroxxi.ruel_li_2.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("id") String id) {
        User user = service.getUser(id);
        UserDTO dto = UserDTOMapper.fromUser(user);
        return ResponseEntity.created(getUserUri()).body(dto);
    }

    @PostMapping
    void createUser(@RequestBody @Valid User user) {
        service.createUser(user);
    }

    private URI getUserUri() {
        return URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/<userId>").toUriString());
    }
}
