package com.example.schedule.service.impl;

import com.example.schedule.dto.SubjectDto;
import com.example.schedule.mapper.SubjectMapper;
import com.example.schedule.model.Subject;
import com.example.schedule.repo.SubjectRepo;
import com.example.schedule.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private SubjectRepo subjectRepo;
    private SubjectMapper subjectMapper;

    @Override
    public Subject create(SubjectDto dto) {
        return subjectRepo.save(subjectMapper.mapToEntity(dto));
    }

    @Override
    public Subject findById(Long id) {
        return subjectRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepo.findAll();
    }

    @Override
    public List<Subject> findAllById(List<Long> ids) {
        return subjectRepo.findAllById(ids);
    }

    @Override
    public Subject update(Long id, SubjectDto dto) {
        return subjectRepo.save(subjectMapper.updateEntity(this.findById(id), dto));
    }

    @Override
    public void delete(Long id) {
        subjectRepo.deleteById(id);
    }
}
