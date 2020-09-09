package by.ceramogrand.processes.service.converter;

import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.converter.impl.UserConverterImpl;
import by.ceramogrand.processes.service.model.UserDTO;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static by.ceramogrand.processes.service.model.UserUtil.getValidUser;
import static by.ceramogrand.processes.service.model.UserUtil.getValidUserDTO;

@RunWith(MockitoJUnitRunner.class)
public class UserConverterImplTest {

    private UserConverter userConverter;
    @Mock
    private UserRoleConverter userRoleConverter;

    @Before
    public void setup() {
        userConverter = new UserConverterImpl(userRoleConverter);
    }

    @Test
    public void getDTOTest_setValidUser_checkIsNotNull() {
        User user = getValidUser();

        UserDTO userDTO = userConverter.getDTO(user);
        Assertions.assertThat(userDTO).isNotNull();
    }

    @Test
    public void getDTOTest_setValidUser_checkEquals() {
        User user = getValidUser();
        UserDTO result = getValidUserDTO();

        UserDTO userDTO = userConverter.getDTO(user);
        Assertions.assertThat(userDTO).isEqualTo(result);
    }

    @Test
    public void getDTOTest_setNull_checkIsNull() {
        User user = null;

        UserDTO userDTO = userConverter.getDTO(user);
        Assertions.assertThat(userDTO).isNull();
    }

    @Test
    public void getModelTest_setValidUserDTO_checkIsNotNull() {
        UserDTO userDTO = getValidUserDTO();

        User user = userConverter.getModel(userDTO);
        Assertions.assertThat(user).isNotNull();
    }

    @Test
    public void getModelTest_setValidUserDTO_checkEquals() {
        UserDTO userDTO = getValidUserDTO();
        User result = getValidUser();

        User user = userConverter.getModel(userDTO);
        Assertions.assertThat(user).isEqualTo(result);
    }

    @Test
    public void getModelTest_setNull_checkIsNull() {
        UserDTO userDTO = null;

        User user = userConverter.getModel(userDTO);
        Assertions.assertThat(user).isNull();
    }

    @Test
    public void getDTOTest_setValidList() {
        List<User> userList = new ArrayList<>();
        userList.add(getValidUser());
        List<UserDTO> result = new ArrayList<>();
        result.add(getValidUserDTO());

        List<UserDTO> userDTOList = userConverter.getDTOs(userList);
        Assertions.assertThat(userDTOList).isEqualTo(result);
    }

}
