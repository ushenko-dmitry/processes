package by.ceramogrand.processes.repository.impl;

import by.ceramogrand.processes.repository.ProcessPatternRepository;
import by.ceramogrand.processes.repository.model.ProcessPattern;
import org.springframework.stereotype.Repository;

@Repository
public class ProcessPatternRepositoryImpl extends GenericRepositoryImpl<Long, ProcessPattern> implements ProcessPatternRepository {
}
