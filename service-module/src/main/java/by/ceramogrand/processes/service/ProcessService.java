package by.ceramogrand.processes.service;

import by.ceramogrand.processes.service.model.AddProcessDTO;
import by.ceramogrand.processes.service.model.ProcessDTO;

import java.util.List;

public interface ProcessService {
    ProcessDTO createProcess(AddProcessDTO addProcessDTO);

    List<ProcessDTO> getProcesses();
}
