package com.example.schedule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Lesson extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @OneToOne
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @OneToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(name = "time", nullable = false)
    private LocalTime time;
}
