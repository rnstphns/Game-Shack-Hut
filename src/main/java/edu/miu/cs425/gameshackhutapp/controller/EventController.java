package edu.miu.cs425.gameshackhutapp.controller;

import edu.miu.cs425.gameshackhutapp.dto.EventDto;
import edu.miu.cs425.gameshackhutapp.model.Event;
import edu.miu.cs425.gameshackhutapp.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/event")
    public ResponseEntity<List<Event>> getAll(){
        var events = eventService.getAll();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<Event> getByID(@PathVariable Long id){
        var event = eventService.get(id);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/event")
    public ResponseEntity<Event> getByID(@RequestBody EventDto data){
        var event = eventService.add(data);
        return ResponseEntity.ok(event);
    }

    @PostMapping("/event/{id}")
    public ResponseEntity<Event> update(@RequestBody EventDto data,@PathVariable Long id){
        var event = eventService.update(data,id);
        return ResponseEntity.ok(event);
    }
    @DeleteMapping("/event/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        eventService.delete(id);
        return ResponseEntity.ok("Success");
    }

}
