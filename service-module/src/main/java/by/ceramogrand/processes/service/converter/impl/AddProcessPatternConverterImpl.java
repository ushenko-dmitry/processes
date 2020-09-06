package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.ProcessPattern;
import by.ceramogrand.processes.service.converter.AddProcessPatternConverter;
import by.ceramogrand.processes.service.model.AddProcessPatternDTO;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AddProcessPatternConverterImpl implements AddProcessPatternConverter {

    @Override
    public AddProcessPatternDTO getDTO(ProcessPattern model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessPattern getModel(AddProcessPatternDTO dto) {
        ProcessPattern processPattern = new ProcessPattern();
        processPattern.setName(dto.getName());
        processPattern.setDescription(dto.getDescription());

        processPattern.setTasks(Collections.emptyList());

        processPattern.setDeleted(dto.getDeleted());

        processPattern.setDateCreated(dto.getDateCreated());
        return processPattern;
    }

    @Override
    public List<AddProcessPatternDTO> getDTOs(List<ProcessPattern> models) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessPattern> getModels(List<AddProcessPatternDTO> dtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
