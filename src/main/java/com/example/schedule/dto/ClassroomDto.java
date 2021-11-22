package com.example.schedule.dto;

import com.example.schedule.config.FullInfo;
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
    @NotNull(groups = FullInfo.class)
    private Integer pavilionNumber;

    @Positive
    @NotNull(groups = FullInfo.class)
    private Integer roomNumber;
}
