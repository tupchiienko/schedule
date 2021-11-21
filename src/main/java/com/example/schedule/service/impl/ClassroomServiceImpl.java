package com.example.schedule.service.impl;

import com.example.schedule.dto.ClassroomDto;
import com.example.schedule.mapper.ClassroomMapper;
import com.example.schedule.model.Classroom;
import com.example.schedule.repo.ClassroomRepo;
import com.example.schedule.service.ClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    private ClassroomRepo classroomRepo;
    private ClassroomMapper classroomMapper;

    @Override
    public Classroom create(ClassroomDto dto) {
        return classroomRepo.save(classroomMapper.mapToEntity(dto));
    }

    @Override
    public Classroom findById(Long id) {
        return classroomRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Classroom> findAll() {
        return classroomRepo.findAll();
    }

    @Override
    public List<Classroom> findAllById(List<Long> ids) {
        return classroomRepo.findAllById(ids);
    }

    @Override
    public Classroom update(Long id, ClassroomDto dto) {
        return classroomRepo.save(classroomMapper.updateEntity(this.findById(id), dto));
    }

    @Override
    public void delete(Long id) {
        classroomRepo.deleteById(id);
    }
}
