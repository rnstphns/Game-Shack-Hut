package edu.miu.cs425.gameshackhutapp.service;

import edu.miu.cs425.gameshackhutapp.dto.EventDto;
import edu.miu.cs425.gameshackhutapp.model.Event;

import java.util.List;

public interface EventService {
    Event add(EventDto event);

    Event get(Long id);

    List<Event> getAll();

    Event update(EventDto event,Long id);

    void delete(Long id);

}
