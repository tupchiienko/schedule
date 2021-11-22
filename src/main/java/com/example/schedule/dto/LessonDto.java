package com.example.schedule.dto;

import com.example.schedule.config.FullInfo;
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

    @NotNull(groups = FullInfo.class)
    private Long subjectId;

    @NotNull(groups = FullInfo.class)
    private Long teacherId;

    @NotNull(groups = FullInfo.class)
    private Long classroomId;

    @NotNull(groups = FullInfo.class)
    @NotEmpty
    private List<Long> groupsIdList;

    @NotNull(groups = FullInfo.class)
    private DayOfWeek dayOfWeek;

    @NotNull(groups = FullInfo.class)
    private LocalTime time;
}
