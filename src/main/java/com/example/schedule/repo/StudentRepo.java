package com.example.schedule.repo;

import com.example.schedule.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepo extends CrudRepository<Student, Long> {
}
