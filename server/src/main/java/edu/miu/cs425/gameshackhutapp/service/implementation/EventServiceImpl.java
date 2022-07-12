package edu.miu.cs425.gameshackhutapp.service.implementation;

import edu.miu.cs425.gameshackhutapp.dto.EventDto;
import edu.miu.cs425.gameshackhutapp.model.Event;
import edu.miu.cs425.gameshackhutapp.repository.EventRepository;
import edu.miu.cs425.gameshackhutapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event add(EventDto eventDto) {
        Event event = new Event(null,eventDto.getEventName(),eventDto.getDate(),eventDto.getCapacity());
        eventRepository.save(event);
        return null;
    }

    @Override
    public Event get(Long id) {
        Optional<Event> event = eventRepository.findById(id);
        return event.get();
    }

    @Override
    public List<Event> getAll() {
        List<Event> events = (List<Event>) eventRepository.findAll();
        return events;
    }

    @Override
    public Event update(EventDto eventDto, Long id) {
        Event event = new Event(id,eventDto.getEventName(),eventDto.getDate(),eventDto.getCapacity());
        var result = eventRepository.save(event);
        return result;
    }

    @Override
    public void delete(Long id) {
        Event event = eventRepository.findById(id).get();
        eventRepository.delete(event);
    }
}
