package by.ceramogrand.processes.web.api;

import by.ceramogrand.processes.service.TaskPatternService;
import by.ceramogrand.processes.service.model.AddTaskPatternDTO;
import by.ceramogrand.processes.service.model.TaskPatternDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
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

    public TaskPatternRestController(TaskPatternService taskPatternService) {
        this.taskPatternService = taskPatternService;
    }

    @GetMapping
    public List<TaskPatternDTO> getTaskPatterns() {
        return taskPatternService.getTaskPatterns();
    }

    @GetMapping("/{id}")
    public TaskPatternDTO getTaskPattern(@PathVariable Long id) {
        return taskPatternService.getTaskPattern(id);
    }

    @PostMapping
    public TaskPatternDTO createTaskPattern(
            @RequestBody AddTaskPatternDTO addTaskPatternDTO
    ) {
        return taskPatternService.createTaskPattern(addTaskPatternDTO);
    }

    @PutMapping("/{id}")
    public TaskPatternDTO updateTaskPattern(
            @PathVariable Long id,
            @RequestBody TaskPatternDTO taskPatternDTO
    ) {
        return taskPatternService.updateTaskPattern(id, taskPatternDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity softDeleteTaskPattern(@PathVariable Long id) {
        return taskPatternService.softDeleteTaskPattern(id);
    }
}
