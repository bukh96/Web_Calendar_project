package webCalendarSpring.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import webCalendarSpring.businesslayer.CustomErrorMessage;
import webCalendarSpring.businesslayer.EventNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity<CustomErrorMessage> handleEventNotFound(EventNotFoundException e) {

        CustomErrorMessage body = new CustomErrorMessage(

                e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }
}
