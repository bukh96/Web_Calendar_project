package webCalendarSpring.persistance;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import webCalendarSpring.businesslayer.Event;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event, Long> {


    List<Event> findEventByDate(LocalDate date);



    List<Event> findByDateGreaterThanEqualAndDateLessThanEqual(@NotNull LocalDate date, @NotNull LocalDate date2);

    Optional<Event> findById(Long id);
}
