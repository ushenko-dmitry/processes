package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.Process;
import by.ceramogrand.processes.service.converter.AddProcessConverter;
import by.ceramogrand.processes.service.model.AddProcessDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AddProcessConverterImpl implements AddProcessConverter {
    @Override
    public AddProcessDTO getDTO(Process process) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Process getModel(AddProcessDTO addProcessDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<AddProcessDTO> getDTOs(List<Process> processes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Process> getModels(List<AddProcessDTO> addProcessDTOS) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
