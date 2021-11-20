package com.example.schedule.repo;

import com.example.schedule.model.Group;
import org.springframework.data.repository.CrudRepository;

public interface GroupRepo extends CrudRepository<Long, Group> {
}
