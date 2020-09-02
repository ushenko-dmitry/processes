package by.ceramogrand.processes.repository;

import by.ceramogrand.processes.repository.model.User;

public interface UserRepository extends GenericRepository<Long, User> {

    User getUserByEmail(String email);

}
