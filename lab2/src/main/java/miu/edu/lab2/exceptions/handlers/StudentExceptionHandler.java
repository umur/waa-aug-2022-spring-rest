package miu.edu.lab2.exceptions.handlers;

import miu.edu.lab2.exceptions.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<Object> exception(StudentNotFoundException exception) {
        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }
}
