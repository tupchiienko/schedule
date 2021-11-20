package com.example.schedule.repo;

import com.example.schedule.model.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepo extends CrudRepository<Teacher, Long> {
}
