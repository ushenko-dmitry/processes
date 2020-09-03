package by.ceramogrand.processes.repository.impl;

import by.ceramogrand.processes.repository.ProcessRepository;
import by.ceramogrand.processes.repository.model.Process;
import org.springframework.stereotype.Repository;

@Repository
public class ProcessRepositoryImpl extends GenericRepositoryImpl<Long, Process> implements ProcessRepository {
}
