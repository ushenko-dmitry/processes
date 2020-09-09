package by.ceramogrand.processes.repository.impl;

import by.ceramogrand.processes.repository.ProcessPatternRepository;
import by.ceramogrand.processes.repository.model.ProcessPattern;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ProcessPatternRepositoryImpl extends GenericRepositoryImpl<Long, ProcessPattern> implements ProcessPatternRepository {

    @Override
    public List<ProcessPattern> findAll() {
        String queryString = "FROM ProcessPattern pp WHERE pp.deleted = false";
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }
}
