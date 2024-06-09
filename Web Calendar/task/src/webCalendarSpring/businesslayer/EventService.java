package webCalendarSpring.businesslayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webCalendarSpring.persistance.EventRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public List<Event> findEventByDate(LocalDate currentDate) {
        return eventRepository.findEventByDate(currentDate);
    }
    public List<Event> todayEvents() {
        return findEventByDate(LocalDate.now());
    }

    public List<Event> findEventsByPeriod(LocalDate startDate, LocalDate endDate) {
        return eventRepository.findByDateGreaterThanEqualAndDateLessThanEqual(startDate,endDate);
    }

    public Event saveEvent(Event save) {

        return eventRepository.save(save);
    }
}
