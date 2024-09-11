package com.reactive.springreactive.ResponseEntityExceptionHandler;

import com.reactive.springreactive.exception.Error;
import com.reactive.springreactive.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class StudentResponseEntityExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public Mono<ResponseEntity<Error>> studentDTOResponseEntityExceptionHandler(StudentNotFoundException ex, WebRequest request) {
        Error error = new Error(ex.getMessage(), HttpStatus.NOT_FOUND);
        return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body(error));
    }
}
