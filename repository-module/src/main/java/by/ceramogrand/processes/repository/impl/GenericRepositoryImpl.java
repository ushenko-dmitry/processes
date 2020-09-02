package by.ceramogrand.processes.repository.impl;

import by.ceramogrand.processes.repository.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class GenericRepositoryImpl<I, T> implements GenericRepository<I, T> {

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericRepositoryImpl() {
        ParameterizedType generalSuperclass = (ParameterizedType) getClass()
                .getGenericSuperclass();
        this.entityClass = (Class<T>) generalSuperclass.getActualTypeArguments()[1];
    }

    @Override
    public void persist(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void merge(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    @Override
    public T findById(I id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        String queryString = "from " + entityClass.getName() + " c";
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @Override
    public Integer getAmountElements() {
        String queryString = "SELECT count(id) FROM " + entityClass.getName() + " c";
        Query query = entityManager.createQuery(queryString);
        try {
            Long count = (Long) query.getSingleResult();
            return count.intValue();
        } catch (NoResultException noResultException) {
            return 0;
        }

    }

}
