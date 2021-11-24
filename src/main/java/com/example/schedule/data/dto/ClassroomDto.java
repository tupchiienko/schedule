package com.example.schedule.data.dto;

import com.example.schedule.data.validation.CreateInfo;
import com.example.schedule.data.validation.UpdateInfo;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomDto {

    @Positive(groups = {CreateInfo.class, UpdateInfo.class})
    @NotNull(groups = CreateInfo.class)
    private Integer pavilionNumber;

    @Positive(groups = {CreateInfo.class, UpdateInfo.class})
    @NotNull(groups = CreateInfo.class)
    private Integer roomNumber;
}
