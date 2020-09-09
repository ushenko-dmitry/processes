package by.ceramogrand.processes.web.api;

import by.ceramogrand.processes.service.TaskPatternService;
import by.ceramogrand.processes.service.UserService;
import by.ceramogrand.processes.service.model.AddTaskPatternDTO;
import by.ceramogrand.processes.service.model.AppUser;
import by.ceramogrand.processes.service.model.TaskPatternDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import java.time.LocalDate;
import java.util.List;
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
@RequestMapping("/api/taskPatterns")
public class TaskPatternRestController {

    private final TaskPatternService taskPatternService;
    private final UserService userService;

    public TaskPatternRestController(
            TaskPatternService taskPatternService,
            UserService userService
    ) {
        this.taskPatternService = taskPatternService;
        this.userService = userService;
    }

    @GetMapping
    public List<TaskPatternDTO> getTaskPatterns() {
        return taskPatternService.getTaskPatterns();
    }

    @GetMapping("/archived")
    public List<TaskPatternDTO> getTaskPatternsArchived() {
        return taskPatternService.getTaskPatternsArchived();
    }

    @GetMapping("/{id}")
    public TaskPatternDTO getTaskPattern(@PathVariable Long id) {
        return taskPatternService.getTaskPattern(id);
    }

    @PostMapping
    public TaskPatternDTO createTaskPattern(
            @RequestBody AddTaskPatternDTO addTaskPatternDTO,
            Authentication authentication
    ) {
        AppUser appUser = (AppUser) authentication.getPrincipal();
        UserDTO user = userService.getUserByEmail(appUser.getUsername());
        addTaskPatternDTO.setCreatedBy(user.getId());
        addTaskPatternDTO.setDateCreated(LocalDate.now());
        return taskPatternService.createTaskPattern(addTaskPatternDTO);
    }

    @PutMapping("/{id}")
    public TaskPatternDTO updateTaskPattern(
            @PathVariable Long id,
            @RequestBody TaskPatternDTO taskPatternDTO,
            Authentication authentication
    ) {
        AppUser appUser = (AppUser) authentication.getPrincipal();
        UserDTO user = userService.getUserByEmail(appUser.getUsername());
        taskPatternDTO.setUpdatedBy(user);
        taskPatternDTO.setDateUpdated(LocalDate.now());
        return taskPatternService.updateTaskPattern(id, taskPatternDTO);
    }

    @DeleteMapping("/{id}")
    public TaskPatternDTO softDeleteTaskPattern(
            @PathVariable Long id,
            Authentication authentication) {
        AppUser appUser = (AppUser) authentication.getPrincipal();
        UserDTO user = userService.getUserByEmail(appUser.getUsername());
        return taskPatternService.softDeleteTaskPattern(id, user);
    }
}
