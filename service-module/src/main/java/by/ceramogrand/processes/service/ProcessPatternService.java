package by.ceramogrand.processes.service;

import by.ceramogrand.processes.service.model.AddProcessPatternDTO;
import by.ceramogrand.processes.service.model.ProcessPatternDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ProcessPatternService {

    public List<ProcessPatternDTO> getProcessPatterns();

    public ProcessPatternDTO getProcessPattern(Long id);

    public ProcessPatternDTO createProcessPattern(AddProcessPatternDTO addProcessPatternDTO);

    public ProcessPatternDTO updateProcessPattern(Long id, ProcessPatternDTO processPatternDTO);

    public ResponseEntity softDeleteProcessPattern(Long id);

}
