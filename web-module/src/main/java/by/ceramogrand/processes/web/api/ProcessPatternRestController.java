package by.ceramogrand.processes.web.api;

import by.ceramogrand.processes.service.ProcessPatternService;
import by.ceramogrand.processes.service.TaskPatternService;
import by.ceramogrand.processes.service.UserService;
import by.ceramogrand.processes.service.model.AddProcessPatternDTO;
import by.ceramogrand.processes.service.model.AppUser;
import by.ceramogrand.processes.service.model.ProcessPatternDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import java.time.LocalDate;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/processPatterns")
public class ProcessPatternRestController {

    private final ProcessPatternService processPatternService;
    private final UserService userService;
    private final TaskPatternService taskPatternService;

    public ProcessPatternRestController(
            ProcessPatternService processPatternService,
            UserService userService,
            TaskPatternService taskPatternService
    ) {
        this.processPatternService = processPatternService;
        this.userService = userService;
        this.taskPatternService = taskPatternService;
    }

    @GetMapping
    public List<ProcessPatternDTO> getProcessPatterns() {
        return processPatternService.getProcessPatterns();
    }

    @GetMapping("/{id}")
    public ProcessPatternDTO getProcessPattern(@PathVariable Long id) {
        return processPatternService.getProcessPattern(id);
    }

    @PostMapping
    public ProcessPatternDTO createProcessPattern(
            @RequestBody AddProcessPatternDTO addProcessPatternDTO,
            Authentication authentication
    ) {
        AppUser appUser = (AppUser) authentication.getPrincipal();
        UserDTO user = userService.getUserByEmail(appUser.getUsername());
        addProcessPatternDTO.setCreatedBy(user.getId());
        addProcessPatternDTO.setDateCreated(LocalDate.now());
        return processPatternService.createProcessPattern(addProcessPatternDTO);
    }

    @PutMapping("/{id}")
    public ProcessPatternDTO updateProcessPattern(
            @PathVariable Long id,
            @RequestBody ProcessPatternDTO processPatternDTO
    ) {
        return processPatternService.updateProcessPattern(id, processPatternDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity softDeleteProcessPattern(@PathVariable Long id) {
        return processPatternService.softDeleteProcessPattern(id);
    }
}
