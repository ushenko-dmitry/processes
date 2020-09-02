package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.Task;
import by.ceramogrand.processes.service.converter.AddTaskConverter;
import by.ceramogrand.processes.service.model.AddTaskDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddTaskConverterImpl implements AddTaskConverter {

    @Override
    public AddTaskDTO getDTO(Task task) {
        return null;
    }

    @Override
    public Task getModel(AddTaskDTO addTaskDTO) {
        Task task = new Task();
        task.setName(addTaskDTO.getName());
        task.setDescription(addTaskDTO.getDescription());

        task.setDeleted(addTaskDTO.getDeleted());

        task.setComplete(addTaskDTO.getComplete());

        task.setDateCreated(addTaskDTO.getDateCreated());
        return task;
    }

    @Override
    public List<AddTaskDTO> getDTOs(List<Task> tasks) {
        return null;
    }

    @Override
    public List<Task> getModels(List<AddTaskDTO> addTaskDTOS) {
        return null;
    }
}
