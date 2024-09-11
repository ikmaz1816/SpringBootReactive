package com.reactive.springreactive.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class StudentDTO {
    private int id;
    private String firstname;
    private String email;
}
