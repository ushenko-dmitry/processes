package by.ceramogrand.processes.service.converter.impl;

import by.ceramogrand.processes.repository.model.Process;
import by.ceramogrand.processes.service.converter.ProcessConverter;
import by.ceramogrand.processes.service.model.ProcessDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProcessConverterImpl implements ProcessConverter {

    @Override
    public ProcessDTO getDTO(Process process) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Process getModel(ProcessDTO processDTO) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<ProcessDTO> getDTOs(List<Process> processes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Process> getModels(List<ProcessDTO> processDTOS) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
