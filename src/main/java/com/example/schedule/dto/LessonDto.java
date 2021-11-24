package com.example.schedule.dto;

import com.example.schedule.data.validation.CreateInfo;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LessonDto {

    @NotNull(groups = CreateInfo.class)
    private Long subjectId;

    @NotNull(groups = CreateInfo.class)
    private Long teacherId;

    @NotNull(groups = CreateInfo.class)
    private Long classroomId;

    @NotNull(groups = CreateInfo.class)
    @NotEmpty(groups = CreateInfo.class)
    private List<Long> groupsIdList;

    @NotNull(groups = CreateInfo.class)
    private DayOfWeek dayOfWeek;

    @NotNull(groups = CreateInfo.class)
    private LocalTime time;
}
