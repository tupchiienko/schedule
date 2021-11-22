package com.example.schedule.service.impl;

import com.example.schedule.dto.StudentDto;
import com.example.schedule.mapper.StudentMapper;
import com.example.schedule.model.Student;
import com.example.schedule.repo.StudentRepo;
import com.example.schedule.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepo studentRepo;
    private StudentMapper studentMapper;

    @Override
    public Student create(StudentDto dto) {
        return studentRepo.save(studentMapper.mapToEntity(dto));
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Student update(Long id, StudentDto dto) {
        return studentRepo.save(studentMapper.updateEntity(this.findById(id), dto));
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }
}
