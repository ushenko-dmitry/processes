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
        return null;
    }

    @Override
    public Process getModel(ProcessDTO processDTO) {
        return null;
    }

    @Override
    public List<ProcessDTO> getDTOs(List<Process> processes) {
        return null;
    }

    @Override
    public List<Process> getModels(List<ProcessDTO> processDTOS) {
        return null;
    }
}
