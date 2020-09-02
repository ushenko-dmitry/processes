package by.ceramogrand.processes.repository.impl;

import by.ceramogrand.processes.repository.TaskRepository;
import by.ceramogrand.processes.repository.model.Task;
import org.springframework.stereotype.Repository;

@Repository
public class TaskRepositoryImpl extends GenericRepositoryImpl<Long, Task> implements TaskRepository {
}
