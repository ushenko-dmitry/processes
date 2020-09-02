package by.ceramogrand.processes.repository.impl;

import by.ceramogrand.processes.repository.UserRepository;
import by.ceramogrand.processes.repository.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<Long, User> implements UserRepository {

    @Override
    public User getUserByEmail(String email) {
        String queryString = "FROM " + entityClass.getSimpleName() + " u "
                + "WHERE u.email=:email";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }
}
