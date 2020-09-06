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
import java.util.List;
import org.springframework.http.ResponseEntity;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseEntity softDeleteTaskPattern(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
