package edu.miu.cs425.gameshackhutapp.repository;

import edu.miu.cs425.gameshackhutapp.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends CrudRepository<Event,Long> {
}
