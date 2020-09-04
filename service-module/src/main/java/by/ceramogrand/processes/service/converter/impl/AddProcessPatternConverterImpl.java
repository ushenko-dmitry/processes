package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.ProcessPattern;
import by.ceramogrand.processes.service.converter.AddProcessPatternConverter;
import by.ceramogrand.processes.service.model.AddProcessDTO;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AddProcessPatternConverterImpl implements AddProcessPatternConverter {

    @Override
    public AddProcessDTO getDTO(ProcessPattern model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessPattern getModel(AddProcessDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AddProcessDTO> getDTOs(List<ProcessPattern> models) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessPattern> getModels(List<AddProcessDTO> dtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
