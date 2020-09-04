package by.ceramogrand.processes.service.model;

import by.ceramogrand.processes.service.enums.UserRoleEnumDTO;

public class AddUserDTO {

    private String email;
    private String password;
    private UserRoleEnumDTO role;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoleEnumDTO getRole() {
        return role;
    }

    public void setRole(UserRoleEnumDTO role) {
        this.role = role;
    }

}
