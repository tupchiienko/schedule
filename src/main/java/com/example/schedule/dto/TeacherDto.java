package com.example.schedule.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {

    @NotNull
    @NotEmpty
    @Size(max = 32)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    private String lastName;
}
