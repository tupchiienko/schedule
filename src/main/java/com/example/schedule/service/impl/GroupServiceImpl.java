package com.example.schedule.service.impl;

import com.example.schedule.data.dto.GroupDto;
import com.example.schedule.mapper.GroupMapper;
import com.example.schedule.data.model.Group;
import com.example.schedule.repo.GroupRepo;
import com.example.schedule.service.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class GroupServiceImpl implements GroupService {

    private GroupRepo groupRepo;
    private GroupMapper groupMapper;

    @Override
    public Group create(GroupDto dto) {
        return groupRepo.save(groupMapper.mapToEntity(dto));
    }

    @Override
    public Group findById(Long id) {
        return groupRepo.findById(id).orElseThrow(
                () -> new NoSuchElementException("Group with id:'" + id + "' does not exist")
        );
    }

    @Override
    public List<Group> findAll() {
        return groupRepo.findAll();
    }

    @Override
    public List<Group> findAllById(List<Long> ids) {
        return groupRepo.findAllById(ids);
    }

    @Override
    public Group update(Long id, GroupDto dto) {
        return groupRepo.save(groupMapper.updateEntity(this.findById(id), dto));
    }

    @Override
    public void delete(Long id) {
        groupRepo.deleteById(id);
    }
}
