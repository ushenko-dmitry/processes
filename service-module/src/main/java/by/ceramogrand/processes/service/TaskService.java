package by.ceramogrand.processes.service;

import by.ceramogrand.processes.service.model.AddTaskDTO;
import by.ceramogrand.processes.service.model.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO addTask(AddTaskDTO taskDTO);

    List<TaskDTO> getTasks();

    TaskDTO getTask(Long id);
}
