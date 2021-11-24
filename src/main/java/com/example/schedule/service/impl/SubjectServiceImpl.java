package com.example.schedule.service.impl;

import com.example.schedule.dto.SubjectDto;
import com.example.schedule.mapper.SubjectMapper;
import com.example.schedule.model.Subject;
import com.example.schedule.repo.SubjectRepo;
import com.example.schedule.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
        return subjectRepo.findById(id).orElseThrow(
                () -> new NoSuchElementException("Subject with id:'" + id + "' does not exist")
        );
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepo.findAll();
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
