package by.ceramogrand.processes.web.api;

import by.ceramogrand.processes.service.enums.UserRoleEnumDTO;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleController {

    @GetMapping
    public List<UserRoleEnumDTO> getUserRoles() {
        return List.of(UserRoleEnumDTO.values());
    }
}
