package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.service.converter.AddUserConverter;
import by.ceramogrand.processes.service.converter.ConverterFacade;
import by.ceramogrand.processes.service.converter.UserConverter;
import org.springframework.stereotype.Component;

@Component
public class ConverterFacadeImpl implements ConverterFacade {

    private final UserConverter userConverter;
    private final AddUserConverter addUserConverter;

    public ConverterFacadeImpl(UserConverter userConverter, AddUserConverter addUserConverter) {
        this.userConverter = userConverter;
        this.addUserConverter = addUserConverter;
    }

    @Override
    public UserConverter getUserConverter() {
        return userConverter;
    }

    @Override
    public AddUserConverter getAddUserConverter() {
        return addUserConverter;
    }
}
