package by.ceramogrand.processes.repository.impl;

import by.ceramogrand.processes.repository.TaskPatternRepository;
import by.ceramogrand.processes.repository.model.TaskPattern;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class TaskPatternRepositoryImpl extends GenericRepositoryImpl<Long, TaskPattern> implements TaskPatternRepository {

    @Override
    public List<TaskPattern> findAll() {
        String queryString = "FROM TaskPattern tp WHERE tp.deleted = false";
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public List<TaskPattern> findAllArchived() {
        String queryString = "FROM TaskPattern tp WHERE tp.deleted = true";
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

}
