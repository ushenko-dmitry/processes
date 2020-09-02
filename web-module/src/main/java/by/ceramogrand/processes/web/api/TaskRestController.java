package by.ceramogrand.processes.web.api;

import by.ceramogrand.processes.service.TaskService;
import by.ceramogrand.processes.service.UserService;
import by.ceramogrand.processes.service.model.AddTaskDTO;
import by.ceramogrand.processes.service.model.AppUser;
import by.ceramogrand.processes.service.model.TaskDTO;
import by.ceramogrand.processes.service.model.UserDTO;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskRestController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public List<TaskDTO> getTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/{id}")
    public TaskDTO getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }

    @PostMapping
    public TaskDTO createTask(@RequestBody AddTaskDTO taskDTO, Authentication authentication) {
        AppUser appUser = (AppUser) authentication.getPrincipal();
        UserDTO user = userService.getUserByEmail(appUser.getUsername());
        taskDTO.setCreatedBy(user.getId());
        taskDTO.setDateCreated(LocalDate.now());
        return taskService.addTask(taskDTO);
    }
}
