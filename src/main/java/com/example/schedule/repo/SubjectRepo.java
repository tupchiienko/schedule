package com.example.schedule.repo;

import com.example.schedule.model.Subject;
import org.springframework.data.repository.CrudRepository;

public interface SubjectRepo extends CrudRepository<Subject, Long> {
}
