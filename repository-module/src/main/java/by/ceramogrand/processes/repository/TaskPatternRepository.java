package by.ceramogrand.processes.repository;

import by.ceramogrand.processes.repository.model.TaskPattern;

import java.util.List;

public interface TaskPatternRepository extends GenericRepository<Long, TaskPattern> {

    List<TaskPattern> findAllArchived();
}
