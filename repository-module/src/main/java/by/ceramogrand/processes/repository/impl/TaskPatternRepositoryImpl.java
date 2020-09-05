package by.ceramogrand.processes.repository.impl;

import by.ceramogrand.processes.repository.TaskPatternRepository;
import by.ceramogrand.processes.repository.model.TaskPattern;
import org.springframework.stereotype.Repository;

@Repository
public class TaskPatternRepositoryImpl extends GenericRepositoryImpl<Long, TaskPattern> implements TaskPatternRepository {

}
