package by.ceramogrand.processes.service;

import by.ceramogrand.processes.service.model.AddUserDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserDTO> getUsers();
    UserDTO getUser(Long id);
    UserDTO addUSer(AddUserDTO userDTO);

}
