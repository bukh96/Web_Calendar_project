package webCalendarSpring.businesslayer;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table
public class Event {


    @NotBlank
    @Column(name = "event")
    private String event;
    @NotNull
    @Column(name = "date")
    private LocalDate date;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq", sequenceName = "event_sequence", allocationSize = 1)
    private Long id;



    public Event(String event, LocalDate date) {
        this.event = event;
        this.date = date;

    }

    public Event(Long id) {
        this.id = id;

    }

    public Event() {

    }


    public LocalDate getDate() {
        return date;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
