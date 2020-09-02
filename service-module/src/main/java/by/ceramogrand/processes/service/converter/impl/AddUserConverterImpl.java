package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.converter.AddUserConverter;
import by.ceramogrand.processes.service.model.AddUserDTO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddUserConverterImpl implements AddUserConverter {

    private final PasswordEncoder passwordEncoder;

    public AddUserConverterImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AddUserDTO getDTO(User user) {
        return null;
    }

    @Override
    public User getModel(AddUserDTO addUserDTO) {
        User user = new User();
        user.setEmail(addUserDTO.getEmail());
        user.setPassword(passwordEncoder.encode(addUserDTO.getPassword()));
        return user;
    }

    @Override
    public List<AddUserDTO> getDTOs(List<User> users) {
        return null;
    }

    @Override
    public List<User> getModels(List<AddUserDTO> addUserDTOS) {
        return null;
    }
}
