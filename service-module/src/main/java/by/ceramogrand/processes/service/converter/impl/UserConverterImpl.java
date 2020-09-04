package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.converter.UserConverter;
import by.ceramogrand.processes.service.model.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserDTO getDTO(User user) {
        if (user == null) return null;
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    @Override
    public User getModel(UserDTO userDTO) {
        if (userDTO == null) return null;
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
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
