package by.ceramogrand.processes.repository.impl;

import by.ceramogrand.processes.repository.UserRepository;
import by.ceramogrand.processes.repository.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<Long, User> implements UserRepository {

}
