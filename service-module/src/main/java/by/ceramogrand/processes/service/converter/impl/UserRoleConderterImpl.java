package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.enums.UserRoleEnum;
import by.ceramogrand.processes.service.enums.UserRoleEnumDTO;
import java.util.List;
import org.springframework.stereotype.Component;
import by.ceramogrand.processes.service.converter.UserRoleConverter;

@Component
public class UserRoleConderterImpl implements UserRoleConverter {

    @Override
    public UserRoleEnumDTO getDTO(UserRoleEnum model) {
        if (model == null) {
            return null;
        }
        switch (model) {
            case ADMIN:
                return UserRoleEnumDTO.ADMIN;
            case MANAGER:
                return UserRoleEnumDTO.MANAGER;
            case SELLER:
                return UserRoleEnumDTO.SELLER;
            default:
                return null;
        }
    }

    @Override
    public UserRoleEnum getModel(UserRoleEnumDTO dto) {
        if (dto == null) {
            return null;
        }
        switch (dto) {
            case ADMIN:
                return UserRoleEnum.ADMIN;
            case MANAGER:
                return UserRoleEnum.MANAGER;
            case SELLER:
                return UserRoleEnum.SELLER;
            default:
                return null;
        }
    }

    @Override
    public List<UserRoleEnumDTO> getDTOs(List<UserRoleEnum> models) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserRoleEnum> getModels(List<UserRoleEnumDTO> dtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
