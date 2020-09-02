package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.Task;
import by.ceramogrand.processes.service.converter.TaskConverter;
import by.ceramogrand.processes.service.converter.UserConverter;
import by.ceramogrand.processes.service.model.TaskDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskConverterImpl implements TaskConverter {

    private final UserConverter userConverter;

    public TaskConverterImpl(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    @Override
    public TaskDTO getDTO(Task task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setName(task.getName());
        taskDTO.setDescription(task.getDescription());

        taskDTO.setDeleted(task.getDeleted());

        taskDTO.setComplete(task.getComplete());
        UserDTO completedBy = userConverter.getDTO(task.getCompletedBy());
        taskDTO.setCompletedBy(completedBy);
        taskDTO.setDateCompleted(task.getDateCompleted());

        UserDTO createdBy = userConverter.getDTO(task.getCreatedBy());
        taskDTO.setCreatedBy(createdBy);
        taskDTO.setDateCreated(task.getDateCreated());
        UserDTO updatedBy = userConverter.getDTO(task.getUpdatedBy());
        taskDTO.setUpdatedBy(updatedBy);
        taskDTO.setDateUpdated(task.getDateUpdated());
        return taskDTO;
    }

    @Override
    public Task getModel(TaskDTO taskDTO) {
        return null;
    }

    @Override
    public List<TaskDTO> getDTOs(List<Task> tasks) {
        List<TaskDTO> taskDTOs = new ArrayList<>();
        for (Task task : tasks) {
            taskDTOs.add(getDTO(task));
        }
        return taskDTOs;
    }

    @Override
    public List<Task> getModels(List<TaskDTO> taskDTOS) {
        return null;
    }
}
