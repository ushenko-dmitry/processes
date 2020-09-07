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

    private final TaskPatternConverter taskPatternConverter;
    private final AddTaskPatternConverter addTaskPatternConverter;

    private final ProcessPatternConverter processPatternConverter;
    private final AddProcessPatternConverter addProcessPatternConverter;

    public ConverterFacadeImpl(
            UserConverter userConverter,
            AddUserConverter addUserConverter,
            TaskConverter taskConverter,
            AddTaskConverter addTaskConverter,
            ProcessConverter processConverter,
            AddProcessConverter addProcessConverter,
            TaskPatternConverter taskPatternConverter,
            AddTaskPatternConverter addTaskPatternConverter,
            ProcessPatternConverter processPatternConverter,
            AddProcessPatternConverter addProcessPatternConverter
    ) {
        this.userConverter = userConverter;
        this.addUserConverter = addUserConverter;
        this.taskConverter = taskConverter;
        this.addTaskConverter = addTaskConverter;
        this.processConverter = processConverter;
        this.addProcessConverter = addProcessConverter;
        this.taskPatternConverter = taskPatternConverter;
        this.addTaskPatternConverter = addTaskPatternConverter;
        this.processPatternConverter = processPatternConverter;
        this.addProcessPatternConverter = addProcessPatternConverter;
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

    @Override
    public TaskPatternConverter getTaskPatternConverter() {
        return taskPatternConverter;
    }

    @Override
    public AddTaskPatternConverter getAddTaskPatternConverter() {
        return addTaskPatternConverter;
    }

    @Override
    public ProcessPatternConverter getProcessPatternConverter() {
        return processPatternConverter;
    }

    @Override
    public AddProcessPatternConverter getAddProcessPatternConverter() {
        return addProcessPatternConverter;
    }
}
