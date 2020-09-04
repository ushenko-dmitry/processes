package by.ceramogrand.processes.service.converter;

public interface ConverterFacade {

    UserConverter getUserConverter();

    AddUserConverter getAddUserConverter();

    TaskConverter getTaskConverter();

    AddTaskConverter getAddTaskConverter();

    ProcessConverter getProcessConverter();

    AddProcessConverter getAddProcessConverter();

    TaskPatternConverter getTaskPatternConverter();

    AddTaskPatternConverter getAddTaskPatternConverter();
}
