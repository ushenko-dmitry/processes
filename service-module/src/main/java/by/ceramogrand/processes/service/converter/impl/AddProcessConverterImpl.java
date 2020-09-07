package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.Process;
import by.ceramogrand.processes.service.converter.AddProcessConverter;
import by.ceramogrand.processes.service.model.AddProcessDTO;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AddProcessConverterImpl implements AddProcessConverter {

    @Override
    public AddProcessDTO getDTO(Process process) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Process getModel(AddProcessDTO addProcessDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.;
    }

    @Override
    public List<AddProcessDTO> getDTOs(List<Process> processes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Process> getModels(List<AddProcessDTO> addProcessDTOS) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
