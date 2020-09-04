package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.TaskPattern;
import by.ceramogrand.processes.service.converter.TaskPatternConverter;
import by.ceramogrand.processes.service.model.TaskPatternDTO;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class TaskPatternConverterImpl implements TaskPatternConverter {

    @Override
    public TaskPatternDTO getDTO(TaskPattern model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TaskPattern getModel(TaskPatternDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TaskPatternDTO> getDTOs(List<TaskPattern> models) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TaskPattern> getModels(List<TaskPatternDTO> dtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
