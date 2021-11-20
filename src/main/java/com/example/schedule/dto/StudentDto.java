package com.example.schedule.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class StudentDto {

    @NotNull
    @NotEmpty
    @Size(max = 32)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(max = 32)
    private String lastName;

    @NotNull
    private Long groupId;
}
