package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.ProcessPattern;
import by.ceramogrand.processes.service.converter.ProcessPatternConverter;
import by.ceramogrand.processes.service.model.ProcessPatternDTO;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProcessPatternConverterImpl implements ProcessPatternConverter {

    @Override
    public ProcessPatternDTO getDTO(ProcessPattern model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProcessPattern getModel(ProcessPatternDTO dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessPatternDTO> getDTOs(List<ProcessPattern> models) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProcessPattern> getModels(List<ProcessPatternDTO> dtos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
