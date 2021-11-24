package com.example.schedule.service;

import com.example.schedule.data.dto.LessonDto;
import com.example.schedule.data.model.Lesson;

import java.time.DayOfWeek;
import java.util.List;

public interface LessonService extends CrudService<Long, Lesson, LessonDto> {

    List<Lesson> findAllByGroupCodeAndDayOfWeek(String groupCode, DayOfWeek dayOfWeek);

    List<Lesson> findAllByTeacherAndDayOfWeek(String firstName, String lastName, DayOfWeek dayOfWeek);
}
