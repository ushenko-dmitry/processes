package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.service.converter.*;
import org.springframework.stereotype.Component;

@Component
public class ConverterFacadeImpl implements ConverterFacade {

    private final UserConverter userConverter;
    private final AddUserConverter addUserConverter;

    private final TaskConverter taskConverter;
    private final AddTaskConverter addTaskConverter;

    private final ProcessConverter processConverter;
    private final AddProcessConverter addProcessConverter;

    public ConverterFacadeImpl(
            UserConverter userConverter,
            AddUserConverter addUserConverter,
            TaskConverter taskConverter,
            AddTaskConverter addTaskConverter,
            ProcessConverter processConverter,
            AddProcessConverter addProcessConverter
    ) {
        this.userConverter = userConverter;
        this.addUserConverter = addUserConverter;
        this.taskConverter = taskConverter;
        this.addTaskConverter = addTaskConverter;
        this.processConverter = processConverter;
        this.addProcessConverter = addProcessConverter;
    }

    @Override
    public UserConverter getUserConverter() {
        return userConverter;
    }

    @Override
    public AddUserConverter getAddUserConverter() {
        return addUserConverter;
    }

    @Override
    public TaskConverter getTaskConverter() {
        return taskConverter;
    }

    @Override
    public AddTaskConverter getAddTaskConverter() {
        return addTaskConverter;
    }

    @Override
    public ProcessConverter getProcessConverter() {
        return processConverter;
    }

    @Override
    public AddProcessConverter getAddProcessConverter() {
        return addProcessConverter;
    }
}
