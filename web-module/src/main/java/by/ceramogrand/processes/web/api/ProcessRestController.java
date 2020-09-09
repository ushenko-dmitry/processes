package by.ceramogrand.processes.web.api;

import by.ceramogrand.processes.repository.model.Process;
import by.ceramogrand.processes.service.ProcessPatternService;
import by.ceramogrand.processes.service.ProcessService;
import by.ceramogrand.processes.service.UserService;
import by.ceramogrand.processes.service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/processes")
public class ProcessRestController {

    @Autowired
    private ProcessService processService;
    @Autowired
    private ProcessPatternService processPatternService;
    @Autowired
    private UserService userService;

    @GetMapping
    public List<ProcessDTO> getProcesses(){
        return processService.getProcesses();
    }

    @PostMapping("/{patternProcessId}")
    public ProcessDTO createProcess(
            @PathVariable Long patternProcessId,
            Authentication authentication
    ) {
        AddProcessDTO addProcessDTO = new AddProcessDTO();
        ProcessPatternDTO processPattern = processPatternService.getProcessPattern(patternProcessId);
        addProcessDTO.setProcess(processPattern);

        AppUser appUser = (AppUser) authentication.getPrincipal();
        UserDTO user = userService.getUserByEmail(appUser.getUsername());
        addProcessDTO.setCreatedBy(user);

        addProcessDTO.setDateCreated(LocalDate.now());
        return processService.createProcess(addProcessDTO);
    }

}
