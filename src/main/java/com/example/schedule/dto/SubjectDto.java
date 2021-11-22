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
public class SubjectDto {

    @NotNull
    @NotEmpty
    @Size(max = 128)
    private String name;
}
