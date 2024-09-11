package com.reactive.springreactive.controller;

import com.reactive.springreactive.dto.StudentDTO;
import com.reactive.springreactive.exception.StudentNotFoundException;
import com.reactive.springreactive.model.Student;
import com.reactive.springreactive.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public Mono<ResponseEntity<StudentDTO>> saveStudent(@RequestBody Student student)
    {
        return this.studentService.save(student).map(ResponseEntity::ok);
    }

    @PostMapping("/getById/{id}")
    public Mono<ResponseEntity<StudentDTO>> getStudentById(@PathVariable Integer id) {

        return this.studentService.findById(id)
                .map(ResponseEntity::ok);
    }

    @GetMapping("/")
    public Flux<StudentDTO> getAllStudent()
    {
        return this.studentService.findAll().delayElements(Duration.ofMillis(1000));
    }
}
