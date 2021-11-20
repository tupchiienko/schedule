package com.example.schedule.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class LessonDto {

    @NotNull
    private Long subjectId;

    @NotNull
    private Long teacherId;

    @NotNull
    private Long classroomId;

    @NotNull
    @NotEmpty
    private List<Long> groupsIdList;

    @NotNull
    private DayOfWeek dayOfWeek;

    @NotNull
    private LocalTime time;
}
