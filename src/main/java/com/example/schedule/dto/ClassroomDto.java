package com.example.schedule.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDto {

    @Positive
    @NotNull
    private Integer pavilionNumber;

    @Positive
    @NotNull
    private Integer roomNumber;
}
