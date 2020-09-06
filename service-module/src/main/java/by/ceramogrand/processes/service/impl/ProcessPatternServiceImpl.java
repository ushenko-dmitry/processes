package by.ceramogrand.processes.service.impl;

import by.ceramogrand.processes.repository.ProcessPatternRepository;
import by.ceramogrand.processes.repository.UserRepository;
import by.ceramogrand.processes.repository.model.ProcessPattern;
import by.ceramogrand.processes.repository.model.User;
import by.ceramogrand.processes.service.ProcessPatternService;
import by.ceramogrand.processes.service.converter.AddProcessPatternConverter;
import by.ceramogrand.processes.service.converter.ConverterFacade;
import by.ceramogrand.processes.service.converter.ProcessPatternConverter;
import by.ceramogrand.processes.service.model.AddProcessPatternDTO;
import by.ceramogrand.processes.service.model.ProcessPatternDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcessPatternServiceImpl implements ProcessPatternService {

    private final ProcessPatternRepository processPatternRepository;
    private final UserRepository userRepository;
    private final ConverterFacade converterFacade;

    public ProcessPatternServiceImpl(ProcessPatternRepository processPatternRepository, UserRepository userRepository, ConverterFacade converterFacade) {
        this.processPatternRepository = processPatternRepository;
        this.userRepository = userRepository;
        this.converterFacade = converterFacade;
    }

    @Override
    public List<ProcessPatternDTO> getProcessPatterns() {
        List<ProcessPattern> processPatterns = processPatternRepository.findAll();
        ProcessPatternConverter processPatternConverter = converterFacade.getProcessPatternConverter();
        return processPatternConverter.getDTOs(processPatterns);
    }

    @Override
    public ProcessPatternDTO getProcessPattern(Long id) {
        ProcessPattern processPattern = processPatternRepository.findById(id);
        ProcessPatternConverter processPatternConverter = converterFacade.getProcessPatternConverter();
        return processPatternConverter.getDTO(processPattern);
    }

    @Override
    public ProcessPatternDTO createProcessPattern(AddProcessPatternDTO addProcessPatternDTO) {
        AddProcessPatternConverter addProcessPatternConverter = converterFacade.getAddProcessPatternConverter();
        ProcessPattern processPattern = addProcessPatternConverter.getModel(addProcessPatternDTO);
        User createdBy = userRepository.findById(addProcessPatternDTO.getCreatedBy());
        processPattern.setCreatedBy(createdBy);
        processPatternRepository.persist(processPattern);
        ProcessPatternConverter processPatternConverter = converterFacade.getProcessPatternConverter();
        return processPatternConverter.getDTO(processPattern);
    }

    @Override
    public ProcessPatternDTO updateProcessPattern(Long id, ProcessPatternDTO processPatternDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseEntity softDeleteProcessPattern(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
