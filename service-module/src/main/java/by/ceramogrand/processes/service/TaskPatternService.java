package by.ceramogrand.processes.service;

import by.ceramogrand.processes.service.model.AddTaskPatternDTO;
import by.ceramogrand.processes.service.model.TaskPatternDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import java.util.List;

public interface TaskPatternService {

    public List<TaskPatternDTO> getTaskPatterns();

    public TaskPatternDTO getTaskPattern(Long id);

    public TaskPatternDTO createTaskPattern(AddTaskPatternDTO addTaskPatternDTO);

    public TaskPatternDTO updateTaskPattern(Long id, TaskPatternDTO taskPatternDTO);

    public TaskPatternDTO softDeleteTaskPattern(Long id, UserDTO userDTO);

}
