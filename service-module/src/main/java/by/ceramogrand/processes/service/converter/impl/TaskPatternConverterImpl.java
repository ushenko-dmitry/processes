package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.TaskPattern;
import by.ceramogrand.processes.service.converter.TaskPatternConverter;
import by.ceramogrand.processes.service.converter.UserConverter;
import by.ceramogrand.processes.service.model.TaskPatternDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TaskPatternConverterImpl implements TaskPatternConverter {

    private final UserConverter userConverter;

    public TaskPatternConverterImpl(UserConverter userConverter) {
        this.userConverter = userConverter;
    }

    @Override
    public TaskPatternDTO getDTO(TaskPattern taskPattern) {
        TaskPatternDTO taskPatternDTO = new TaskPatternDTO();
        taskPatternDTO.setId(taskPattern.getId());
        taskPatternDTO.setName(taskPattern.getName());
        taskPatternDTO.setDescription(taskPattern.getDescription());

        taskPatternDTO.setDeleted(taskPattern.getDeleted());

        UserDTO createdBy = userConverter.getDTO(taskPattern.getCreatedBy());
        taskPatternDTO.setCreatedBy(createdBy);
        taskPatternDTO.setDateCreated(taskPattern.getDateCreated());
        UserDTO updatedBy = userConverter.getDTO(taskPattern.getUpdatedBy());
        taskPatternDTO.setUpdatedBy(updatedBy);
        taskPatternDTO.setDateUpdated(taskPattern.getDateUpdated());
        return taskPatternDTO;
    }

    @Override
    public TaskPattern getModel(TaskPatternDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TaskPatternDTO> getDTOs(List<TaskPattern> models) {
        List<TaskPatternDTO> taskPatternDTOs = new ArrayList<>();
        for (TaskPattern model : models) {
            taskPatternDTOs.add(getDTO(model));
        }
        return taskPatternDTOs;
    }

    @Override
    public List<TaskPattern> getModels(List<TaskPatternDTO> dtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
