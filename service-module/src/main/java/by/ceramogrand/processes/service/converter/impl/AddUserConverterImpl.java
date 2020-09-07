package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.enums.UserRoleEnum;
import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.converter.AddUserConverter;
import by.ceramogrand.processes.service.converter.UserRoleConverter;
import by.ceramogrand.processes.service.model.AddUserDTO;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AddUserConverterImpl implements AddUserConverter {

    private final PasswordEncoder passwordEncoder;
    private final UserRoleConverter userRoleConverter;

    public AddUserConverterImpl(
            PasswordEncoder passwordEncoder,
            UserRoleConverter userRoleConverter
    ) {
        this.passwordEncoder = passwordEncoder;
        this.userRoleConverter = userRoleConverter;
    }

    @Override
    public AddUserDTO getDTO(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public User getModel(AddUserDTO addUserDTO) {
        User user = new User();
        user.setEmail(addUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(addUserDTO.getPassword()));
        UserRoleEnum userRole = userRoleConverter.getModel(addUserDTO.getRole());
        user.setRole(userRole);
        return user;
    }

    @Override
    public List<AddUserDTO> getDTOs(List<User> users) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<User> getModels(List<AddUserDTO> addUserDTOS) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
