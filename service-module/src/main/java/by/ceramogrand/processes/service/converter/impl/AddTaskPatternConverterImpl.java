package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.TaskPattern;
import by.ceramogrand.processes.service.converter.AddTaskPatternConverter;
import by.ceramogrand.processes.service.model.AddTaskPatternDTO;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AddTaskPatternConverterImpl implements AddTaskPatternConverter {

    @Override
    public AddTaskPatternDTO getDTO(TaskPattern model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TaskPattern getModel(AddTaskPatternDTO addTaskPatternDTO) {
        TaskPattern taskPattern = new TaskPattern();
        taskPattern.setName(addTaskPatternDTO.getName());
        taskPattern.setDescription(addTaskPatternDTO.getDescription());
        taskPattern.setDeleted(addTaskPatternDTO.getDeleted());
        taskPattern.setDateCreated(addTaskPatternDTO.getDateCreated());
        return taskPattern;
    }

    @Override
    public List<AddTaskPatternDTO> getDTOs(List<TaskPattern> models) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TaskPattern> getModels(List<AddTaskPatternDTO> dtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
