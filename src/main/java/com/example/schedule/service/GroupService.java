package com.example.schedule.service;

import com.example.schedule.dto.GroupDto;
import com.example.schedule.model.Group;

import java.util.List;

public interface GroupService extends CrudService<Long, Group, GroupDto> {

    List<Group> findAllById(List<Long> ids);
}
