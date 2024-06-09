package webCalendarSpring.presentation;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import webCalendarSpring.businesslayer.Event;
import webCalendarSpring.businesslayer.EventNotFoundException;
import webCalendarSpring.businesslayer.EventService;
import webCalendarSpring.persistance.EventRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@Validated
public class CallendarController {
    @Autowired
    EventService eventService;
    @Autowired
    EventRepository eventRepository;

    public CallendarController() {
    }


    @GetMapping("/event/today")
    public ResponseEntity<?> getTodayEvents() {
        List<Event> todayEvents = eventService.todayEvents();
        return ResponseEntity.ok(todayEvents);
    }

    @GetMapping("/event/{id}")
    @Transactional
    public Optional<Event> getEventById(@PathVariable Long id) {
        Optional<Event> eventById = eventRepository.findById(id);
        if (eventById.isEmpty()) {
            throw new EventNotFoundException("The event doesn't exist!");
        } else {
            return eventById;
        }

    }

    @DeleteMapping("/event/{id}")
    @Transactional
    public ResponseEntity<?> deleteEventById(@PathVariable Long id) {
        Optional<Event> eventById = eventRepository.findById(id);
        if (eventById.isEmpty()) {
            throw new EventNotFoundException("The event doesn't exist!");
        } else {
            eventRepository.deleteById(id);
            return new ResponseEntity<>(eventById, HttpStatus.OK);
        }
    }


    @GetMapping("/event")
    public ResponseEntity<List<Event>> getAllEvent() {

        if (eventRepository.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(eventRepository.findAll());
        }

    }

    @GetMapping(value = "/event", params = {"start_time", "end_time"})
    public ResponseEntity<?> eventListByInterval(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start_time,
                                                 @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end_time) {
        List<Event> events = eventService.findEventsByPeriod(start_time, end_time);
        List<Event> allEvents = eventRepository.findAll();
        if (events.isEmpty()) return new ResponseEntity<>(allEvents, HttpStatus.NO_CONTENT);
        else {
            return ResponseEntity.ok(events);
        }
    }

    @PostMapping("/event")
    public ResponseEntity<?> postEvent(@RequestBody Event event) {
        if (event == null || event.getEvent() == null || event.getEvent().isBlank()
                || event.getDate() == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        else {

            Event newEvent = eventService.saveEvent(new Event(event.getEvent(), event.getDate()));
            eventRepository.save(newEvent);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "The event has been added!");
            response.put("event", event.getEvent());
            response.put("date", event.getDate());
            return ResponseEntity.ok(response);


        }

    }
}
