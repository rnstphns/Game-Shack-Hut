package edu.miu.cs.cs425.eregistrarwebapi.repository;

import edu.miu.cs.cs425.eregistrarwebapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    public User findByEmail(String email);
}
