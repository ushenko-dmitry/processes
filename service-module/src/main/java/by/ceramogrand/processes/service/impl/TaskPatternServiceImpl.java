package by.ceramogrand.processes.service.impl;

import by.ceramogrand.processes.repository.TaskPatternRepository;
import by.ceramogrand.processes.repository.UserRepository;
import by.ceramogrand.processes.repository.model.TaskPattern;
import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.TaskPatternService;
import by.ceramogrand.processes.service.converter.AddTaskPatternConverter;
import by.ceramogrand.processes.service.converter.ConverterFacade;
import by.ceramogrand.processes.service.converter.TaskPatternConverter;
import by.ceramogrand.processes.service.model.AddTaskPatternDTO;
import by.ceramogrand.processes.service.model.TaskPatternDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskPatternServiceImpl implements TaskPatternService {

    private final TaskPatternRepository taskPatternRepository;
    private final UserRepository userRepository;
    private final ConverterFacade converterFacade;

    public TaskPatternServiceImpl(
            TaskPatternRepository taskPatternRepository,
            UserRepository userRepository,
            ConverterFacade converterFacade
    ) {
        this.taskPatternRepository = taskPatternRepository;
        this.userRepository = userRepository;
        this.converterFacade = converterFacade;
    }

    @Override
    public List<TaskPatternDTO> getTaskPatterns() {
        List<TaskPattern> taskPatterns = taskPatternRepository.findAll();
        TaskPatternConverter taskPatternConverter = converterFacade.getTaskPatternConverter();
        return taskPatternConverter.getDTOs(taskPatterns);
    }

    @Override
    public TaskPatternDTO getTaskPattern(Long id) {
        TaskPattern taskPattern = taskPatternRepository.findById(id);
        TaskPatternConverter taskPatternConverter = converterFacade.getTaskPatternConverter();
        return taskPatternConverter.getDTO(taskPattern);
    }

    @Override
    public TaskPatternDTO createTaskPattern(AddTaskPatternDTO addTaskPatternDTO) {
        AddTaskPatternConverter addTaskPatternConverter = converterFacade.getAddTaskPatternConverter();
        TaskPattern taskPattern = addTaskPatternConverter.getModel(addTaskPatternDTO);
        User createdBy = userRepository.findById(addTaskPatternDTO.getCreatedBy());
        taskPattern.setCreatedBy(createdBy);
        taskPatternRepository.persist(taskPattern);
        TaskPatternConverter taskPatternConverter = converterFacade.getTaskPatternConverter();
        return taskPatternConverter.getDTO(taskPattern);
    }

    @Override
    public TaskPatternDTO updateTaskPattern(Long id, TaskPatternDTO taskPatternDTO) {
        TaskPattern taskPattern = taskPatternRepository.findById(id);
        taskPattern.setName(taskPatternDTO.getName());
        taskPattern.setDescription(taskPatternDTO.getDescription());

        UserDTO updatedByDTO = taskPatternDTO.getUpdatedBy();
        User updatedBy = userRepository.findById(updatedByDTO.getId());
        taskPattern.setUpdatedBy(updatedBy);
        taskPattern.setDateUpdated(taskPatternDTO.getDateUpdated());

        TaskPatternConverter taskPatternConverter = converterFacade.getTaskPatternConverter();
        return taskPatternConverter.getDTO(taskPattern);
    }

    @Override
    public TaskPatternDTO softDeleteTaskPattern(Long id, UserDTO userDTO) {
        TaskPattern taskPattern = taskPatternRepository.findById(id);
        taskPattern.setDeleted(true);

        User updatedBy = userRepository.findById(userDTO.getId());
        taskPattern.setUpdatedBy(updatedBy);
        taskPattern.setDateUpdated(LocalDate.now());

        TaskPatternConverter taskPatternConverter = converterFacade.getTaskPatternConverter();
        return taskPatternConverter.getDTO(taskPattern);
    }

    @Override
    public List<TaskPatternDTO> getTaskPatternsArchived() {
        List<TaskPattern> taskPatterns = taskPatternRepository.findAllArchived();
        TaskPatternConverter taskPatternConverter = converterFacade.getTaskPatternConverter();
        return taskPatternConverter.getDTOs(taskPatterns);
    }

}
