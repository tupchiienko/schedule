package com.example.schedule.repo;

import com.example.schedule.model.Lesson;
import org.springframework.data.repository.CrudRepository;

public interface LessonRepo extends CrudRepository<Long, Lesson> {
}
