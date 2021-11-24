package com.example.schedule.repo;

import com.example.schedule.data.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.DayOfWeek;
import java.util.List;

public interface LessonRepo extends JpaRepository<Lesson, Long> {

    @Query(
            value = "SELECT l.* FROM lessons_groups lg " +
                    "JOIN lessons l ON lg.lesson_id = l.id " +
                    "JOIN groups g ON g.id = lg.group_id " +
                    "WHERE g.code = ?1 AND l.day_of_week = ?2",
            nativeQuery = true
    )
    List<Lesson> findAllByGroupCodeAndDayOfWeek(String groupCode, Integer dayOfWeekOrdinal);

    List<Lesson> findAllByTeacherFirstNameAndTeacherLastNameAndDayOfWeek(
            String teacherFirstName,
            String teacherLastName,
            DayOfWeek dayOfWeek
    );
}
