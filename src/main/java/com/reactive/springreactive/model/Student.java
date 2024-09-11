package com.reactive.springreactive.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Builder
@Table(name="student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @JsonIgnore
    private int id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String address;
}
