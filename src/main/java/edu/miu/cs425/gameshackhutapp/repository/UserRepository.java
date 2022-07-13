package edu.miu.cs425.gameshackhutapp.repository;

import edu.miu.cs425.gameshackhutapp.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    public User findByEmail(String email);
}
