package com.example.schedule.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ClassroomDto {

    @Positive
    @NotNull
    private Integer pavilionNumber;

    @Positive
    @NotNull
    private Integer roomNumber;
}
