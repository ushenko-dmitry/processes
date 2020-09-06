package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.enums.UserRoleEnum;
import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.converter.UserConverter;
import by.ceramogrand.processes.service.converter.UserRoleConverter;
import by.ceramogrand.processes.service.enums.UserRoleEnumDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserConverterImpl implements UserConverter {

    private final UserRoleConverter userRoleConverter;

    public UserConverterImpl(UserRoleConverter userRoleConverter) {
        this.userRoleConverter = userRoleConverter;
    }

    @Override
    public UserDTO getDTO(User user) {
        if (user == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        UserRoleEnumDTO userDTORole = userRoleConverter.getDTO(user.getRole());
        userDTO.setRole(userDTORole);
        return userDTO;
    }

    @Override
    public User getModel(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        UserRoleEnum userRole = userRoleConverter.getModel(userDTO.getRole());
        user.setRole(userRole);
        return user;
    }

    @Override
    public List<UserDTO> getDTOs(List<User> users) {
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            userDTOList.add(getDTO(user));
        }
        return userDTOList;
    }

    @Override
    public List<User> getModels(List<UserDTO> userDTOs) {
        List<User> users = new ArrayList<>();
        for (UserDTO userDTO : userDTOs) {
            users.add(getModel(userDTO));
        }
        return users;
    }
}
