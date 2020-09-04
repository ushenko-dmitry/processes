package by.ceramogrand.processes.service.model;

import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.constants.UserParameters;

public class UserUtil {

    public static User getValidUser() {
        User user = new User();
        user.setId(UserParameters.USER_ID);
        user.setEmail(UserParameters.USER_EMAIL);
        user.setPassword(UserParameters.USER_PASSWORD);
        return user;
    }

    public static UserDTO getValidUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(UserParameters.USER_ID);
        userDTO.setEmail(UserParameters.USER_EMAIL);
        userDTO.setPassword(UserParameters.USER_PASSWORD);
        return userDTO;
    }
}
