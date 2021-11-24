package com.example.schedule.service.impl;

import com.example.schedule.data.dto.LessonDto;
import com.example.schedule.mapper.LessonMapper;
import com.example.schedule.data.model.Lesson;
import com.example.schedule.repo.LessonRepo;
import com.example.schedule.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class LessonServiceImpl implements LessonService {

    private LessonRepo lessonRepo;
    private LessonMapper lessonMapper;

    @Override
    public Lesson create(LessonDto dto) {
        return lessonRepo.save(lessonMapper.mapToEntity(dto));
    }

    @Override
    public Lesson findById(Long id) {
        return lessonRepo.findById(id).orElseThrow(
                () -> new NoSuchElementException("Lesson with id:'" + id + "' does not exist")
        );
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepo.findAll();
    }

    @Override
    public Lesson update(Long id, LessonDto dto) {
        return lessonRepo.save(lessonMapper.updateEntity(this.findById(id), dto));
    }

    @Override
    public void delete(Long id) {
        lessonRepo.deleteById(id);
    }


    @Override
    public List<Lesson> findAllByGroupCodeAndDayOfWeek(String groupCode, DayOfWeek dayOfWeek) {
        return lessonRepo.findAllByGroupCodeAndDayOfWeek(groupCode, dayOfWeek.ordinal());
    }

    @Override
    public List<Lesson> findAllByTeacherAndDayOfWeek(String firstName, String lastName, DayOfWeek dayOfWeek) {
        return lessonRepo.findAllByTeacherFirstNameAndTeacherLastNameAndDayOfWeek(firstName, lastName, dayOfWeek);
    }
}
