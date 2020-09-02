package by.ceramogrand.processes.service.impl;

import by.ceramogrand.processes.repository.UserRepository;
import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.UserService;
import by.ceramogrand.processes.service.converter.AddUserConverter;
import by.ceramogrand.processes.service.converter.ConverterFacade;
import by.ceramogrand.processes.service.converter.UserConverter;
import by.ceramogrand.processes.service.model.AddUserDTO;
import by.ceramogrand.processes.service.model.AppUser;
import by.ceramogrand.processes.service.model.UserDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConverterFacade converterFacade;

    public UserServiceImpl(
            UserRepository userRepository,
            ConverterFacade converterFacade) {
        this.userRepository = userRepository;
        this.converterFacade = converterFacade;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        UserConverter userConverter = converterFacade.getUserConverter();
        UserDTO userDTO = userConverter.getDTO(user);

        if (userDTO == null) {
            throw new UsernameNotFoundException("User is not found");
        }
        AppUser appUser = new AppUser(userDTO);
        return appUser;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findAll();
        UserConverter userConverter = converterFacade.getUserConverter();
        return userConverter.getDTOs(userList);
    }

    @Override
    public UserDTO getUser(Long id) {
        User user = userRepository.findById(id);
        UserConverter userConverter = converterFacade.getUserConverter();
        return userConverter.getDTO(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        UserConverter userConverter = converterFacade.getUserConverter();
        return userConverter.getDTO(user);
    }

    @Override
    public UserDTO addUSer(AddUserDTO userDTO) {
        AddUserConverter addUserConverter = converterFacade.getAddUserConverter();
        User user = addUserConverter.getModel(userDTO);
        userRepository.persist(user);
        UserConverter userConverter = converterFacade.getUserConverter();
        return userConverter.getDTO(user);
    }
}
