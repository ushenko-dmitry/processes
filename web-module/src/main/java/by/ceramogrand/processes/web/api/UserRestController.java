package by.ceramogrand.processes.web.api;

import by.ceramogrand.processes.service.UserService;
import by.ceramogrand.processes.service.model.AddUserDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody AddUserDTO userDTO) {
        return userService.addUSer(userDTO);
    }
}
