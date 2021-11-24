package com.example.schedule.service.impl;

import com.example.schedule.dto.TeacherDto;
import com.example.schedule.mapper.TeacherMapper;
import com.example.schedule.model.Teacher;
import com.example.schedule.repo.TeacherRepo;
import com.example.schedule.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;
    private TeacherMapper teacherMapper;

    @Override
    public Teacher create(TeacherDto dto) {
        return teacherRepo.save(teacherMapper.mapToEntity(dto));
    }

    @Override
    public Teacher findById(Long id) {
        return teacherRepo.findById(id).orElseThrow(
                () -> new NoSuchElementException("Teacher with id:'" + id + "' does not exist")
        );
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepo.findAll();
    }

    @Override
    public Teacher update(Long id, TeacherDto dto) {
        return teacherRepo.save(teacherMapper.updateEntity(this.findById(id), dto));
    }

    @Override
    public void delete(Long id) {
        teacherRepo.deleteById(id);
    }
}
