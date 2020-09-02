package by.ceramogrand.processes.service.impl;

import by.ceramogrand.processes.repository.TaskRepository;
import by.ceramogrand.processes.repository.UserRepository;
import by.ceramogrand.processes.repository.model.Task;
import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.TaskService;
import by.ceramogrand.processes.service.converter.AddTaskConverter;
import by.ceramogrand.processes.service.converter.ConverterFacade;
import by.ceramogrand.processes.service.converter.TaskConverter;
import by.ceramogrand.processes.service.model.AddTaskDTO;
import by.ceramogrand.processes.service.model.TaskDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ConverterFacade converterFacade;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository, ConverterFacade converterFacade) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.converterFacade = converterFacade;
    }

    @Override
    public TaskDTO addTask(AddTaskDTO taskDTO) {
        AddTaskConverter addTaskConverter = converterFacade.getAddTaskConverter();
        Task task = addTaskConverter.getModel(taskDTO);
        User createdBy = userRepository.findById(taskDTO.getCreatedBy());
        task.setCreatedBy(createdBy);
        taskRepository.persist(task);
        TaskConverter taskConverter = converterFacade.getTaskConverter();
        return taskConverter.getDTO(task);
    }

    @Override
    public List<TaskDTO> getTasks() {
        List<Task> tasks = taskRepository.findAll();
        TaskConverter taskConverter = converterFacade.getTaskConverter();
        return taskConverter.getDTOs(tasks);
    }

    @Override
    public TaskDTO getTask(Long id) {
        Task task = taskRepository.findById(id);
        TaskConverter taskConverter = converterFacade.getTaskConverter();
        return taskConverter.getDTO(task);
    }
}
