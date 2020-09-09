package by.ceramogrand.processes.web.api;

import by.ceramogrand.processes.service.enums.UserRoleEnumDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleController {

    @GetMapping
    public List<UserRoleEnumDTO> getUserRoles() {
        return Arrays.asList(UserRoleEnumDTO.values());
    }
}
