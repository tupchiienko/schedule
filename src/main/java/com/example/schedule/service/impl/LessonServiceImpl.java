package com.example.schedule.service.impl;

import com.example.schedule.dto.LessonDto;
import com.example.schedule.mapper.LessonMapper;
import com.example.schedule.model.Lesson;
import com.example.schedule.repo.LessonRepo;
import com.example.schedule.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return lessonRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepo.findAll();
    }

    @Override
    public List<Lesson> findAllById(List<Long> ids) {
        return lessonRepo.findAllById(ids);
    }

    @Override
    public Lesson update(Long id, LessonDto dto) {
        return lessonRepo.save(lessonMapper.updateEntity(this.findById(id), dto));
    }

    @Override
    public void delete(Long id) {

    }
}
