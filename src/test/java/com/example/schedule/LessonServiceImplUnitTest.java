package com.example.schedule;

import com.example.schedule.dto.LessonDto;
import com.example.schedule.mapper.LessonMapper;
import com.example.schedule.model.*;
import com.example.schedule.repo.LessonRepo;
import com.example.schedule.service.impl.LessonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class LessonServiceImplUnitTest {

    @Mock
    private LessonRepo lessonRepo;
    @Mock
    private LessonMapper lessonMapper;

    @InjectMocks
    private LessonServiceImpl lessonService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createLessonTest() {
        LessonDto lessonDto = new LessonDto(
                1L,
                1L,
                1L,
                List.of(1L, 2L),
                DayOfWeek.MONDAY,
                LocalTime.of(12, 0)
        );
        Lesson lesson = new Lesson(
                new Subject("Math"),
                new Teacher("Ivan", "Ivanov"),
                new Classroom(1, 56),
                List.of(new Group("IO-01"), new Group("IO-02")),
                DayOfWeek.MONDAY,
                LocalTime.of(12, 0)
        );

        Mockito.when(lessonMapper.mapToEntity(lessonDto)).thenReturn(lesson);
        Mockito.when(lessonRepo.save(lesson)).thenReturn(lesson);

        Lesson created = lessonService.create(lessonDto);

        Mockito.verify(lessonMapper, Mockito.times(1)).mapToEntity(lessonDto);
        Mockito.verify(lessonRepo, Mockito.times(1)).save(lesson);
        Assert.assertEquals(lesson, created);
    }

    @Test
    public void findLessonByIdTest() {
        Lesson lesson = new Lesson(
                new Subject("English"),
                new Teacher("Maria", "Petrova"),
                new Classroom(12, 6),
                List.of(new Group("IV-72")),
                DayOfWeek.TUESDAY,
                LocalTime.of(14, 0)
        );

        Mockito.when(lessonRepo.findById(1L)).thenReturn(Optional.of(lesson));
        Mockito.when(lessonRepo.findById(2L)).thenReturn(Optional.empty());

        Lesson byId = lessonService.findById(1L);

        Mockito.verify(lessonRepo, Mockito.times(1)).findById(1L);
        Assert.assertEquals(lesson, byId);
        Assert.assertThrows(NoSuchElementException.class, () -> lessonService.findById(2L));
    }

    @Test
    public void findAllLessonsTest() {
        Lesson lesson1 = new Lesson(
                new Subject("English"),
                new Teacher("Maria", "Petrova"),
                new Classroom(12, 6),
                List.of(new Group("IV-72")),
                DayOfWeek.TUESDAY,
                LocalTime.of(14, 0)
        );
        Lesson lesson2 = new Lesson(
                new Subject("Math"),
                new Teacher("Ivan", "Ivanov"),
                new Classroom(1, 56),
                List.of(new Group("IO-01"), new Group("IO-02")),
                DayOfWeek.MONDAY,
                LocalTime.of(12, 0)
        );
        Lesson lesson3 = new Lesson(
                new Subject("Programing"),
                new Teacher("Andrey", "Stepanov"),
                new Classroom(3, 154),
                List.of(new Group("IA-93")),
                DayOfWeek.FRIDAY,
                LocalTime.of(10, 0)
        );
        List<Lesson> lessons = List.of(lesson1, lesson2, lesson3);

        Mockito.when(lessonRepo.findAll()).thenReturn(lessons);

        List<Lesson> all = lessonService.findAll();

        Mockito.verify(lessonRepo, Mockito.times(1)).findAll();
        Assert.assertEquals(lessons, all);
    }

    @Test
    public void updateLessonTest() {
        Lesson lesson = new Lesson(
                new Subject("Programing"),
                new Teacher("Andrey", "Stepanov"),
                new Classroom(3, 154),
                List.of(new Group("IA-93")),
                DayOfWeek.FRIDAY,
                LocalTime.of(10, 0)
        );
        LessonDto lessonDto = new LessonDto(
                null,
                null,
                null,
                null,
                null,
                LocalTime.of(8, 0)
        );
        Lesson newLesson = new Lesson(
                new Subject("Programing"),
                new Teacher("Andrey", "Stepanov"),
                new Classroom(3, 154),
                List.of(new Group("IA-93")),
                DayOfWeek.FRIDAY,
                LocalTime.of(8, 0)
        );

        Mockito.when(lessonRepo.findById(1L)).thenReturn(Optional.of(lesson));
        Mockito.when(lessonMapper.updateEntity(lesson, lessonDto)).thenReturn(newLesson);
        Mockito.when(lessonRepo.save(newLesson)).thenReturn(newLesson);

        Lesson update = lessonService.update(1L, lessonDto);

        Mockito.verify(lessonRepo, Mockito.times(1)).findById(1L);
        Mockito.verify(lessonRepo, Mockito.times(1)).save(newLesson);
        Mockito.verify(lessonMapper, Mockito.times(1)).updateEntity(lesson, lessonDto);
        Assert.assertEquals(newLesson, update);
    }

    @Test
    public void deleteLessonTest() {
        lessonService.delete(1L);

        Mockito.verify(lessonRepo, Mockito.times(1)).deleteById(1L);
    }
}
