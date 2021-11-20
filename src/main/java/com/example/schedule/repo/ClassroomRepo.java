package com.example.schedule.repo;

import com.example.schedule.model.Classroom;
import org.springframework.data.repository.CrudRepository;

public interface ClassroomRepo extends CrudRepository<Long, Classroom> {
}
