package com.reactive.springreactive.service;

import com.reactive.springreactive.dto.StudentDTO;
import com.reactive.springreactive.exception.StudentNotFoundException;
import com.reactive.springreactive.model.Student;
import com.reactive.springreactive.repository.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final ModelMapper modelMapper;

    public StudentService(StudentRepository studentRepository,ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    public Mono<StudentDTO> save(Student student) {
        return studentRepository.save(student).map(user -> modelMapper.map(user, StudentDTO.class));
    }

    public Flux<StudentDTO> findAll() {
        return studentRepository.findAll().map(user -> modelMapper.map(user, StudentDTO.class));
    }

    public Mono<StudentDTO> findById(int id) {
        return studentRepository.findById(id)
                .map(user -> modelMapper.map(user, StudentDTO.class))
                .switchIfEmpty(Mono.error(new StudentNotFoundException("Student not found with id: " + id)));
    }
}
