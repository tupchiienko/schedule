package com.example.schedule;

import com.example.schedule.data.dto.GroupDto;
import com.example.schedule.mapper.GroupMapper;
import com.example.schedule.data.model.Group;
import com.example.schedule.repo.GroupRepo;
import com.example.schedule.service.impl.GroupServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class GroupServiceImplUnitTest {

    @Mock
    private GroupRepo groupRepo;
    @Mock
    private GroupMapper groupMapper;

    @InjectMocks
    private GroupServiceImpl groupService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createGroupTest() {
        GroupDto groupDto = new GroupDto("IO-72");
        Group group = new Group("IO-02");

        Mockito.when(groupMapper.mapToEntity(groupDto)).thenReturn(group);
        Mockito.when(groupRepo.save(group)).thenReturn(group);

        Group created = groupService.create(groupDto);

        Mockito.verify(groupMapper, Mockito.times(1)).mapToEntity(groupDto);
        Mockito.verify(groupRepo, Mockito.times(1)).save(group);
        Assert.assertEquals(group, created);
    }

    @Test
    public void findGroupByIdTest() {
        Group group = new Group("AM-32");

        Mockito.when(groupRepo.findById(1L)).thenReturn(Optional.of(group));
        Mockito.when(groupRepo.findById(2L)).thenReturn(Optional.empty());

        Group byId = groupService.findById(1L);

        Mockito.verify(groupRepo, Mockito.times(1)).findById(1L);
        Assert.assertEquals(group, byId);
        Assert.assertThrows(NoSuchElementException.class, () -> groupService.findById(2L));
    }

    @Test
    public void findAllGroupsTest() {
        Group group1 = new Group("IO-73");
        Group group2 = new Group("TI-01");
        Group group3 = new Group("EM-94");
        List<Group> groups = List.of(group1, group2, group3);

        Mockito.when(groupRepo.findAll()).thenReturn(groups);

        List<Group> all = groupService.findAll();

        Mockito.verify(groupRepo, Mockito.times(1)).findAll();
        Assert.assertEquals(groups, all);
    }

    @Test
    public void findAllGroupsByIdTest() {
        Group group1 = new Group("IO-73");
        Group group2 = new Group("TI-01");
        Group group3 = new Group("EM-94");
        List<Group> groups = List.of(group1, group2, group3);
        List<Long> ids = List.of(1L, 2L, 3L);

        Mockito.when(groupRepo.findAllById(ids)).thenReturn(groups);

        List<Group> allById = groupService.findAllById(ids);

        Mockito.verify(groupRepo, Mockito.times(1)).findAllById(ids);
        Assert.assertEquals(groups, allById);
    }

    @Test
    public void updateGroupTest() {
        Group group = new Group("IO-03");
        GroupDto groupDto = new GroupDto("IO-73");
        Group newGroup = new Group("IO-73");

        Mockito.when(groupRepo.findById(1L)).thenReturn(Optional.of(group));
        Mockito.when(groupMapper.updateEntity(group, groupDto)).thenReturn(newGroup);
        Mockito.when(groupRepo.save(newGroup)).thenReturn(newGroup);

        Group update = groupService.update(1L, groupDto);

        Mockito.verify(groupRepo, Mockito.times(1)).findById(1L);
        Mockito.verify(groupRepo, Mockito.times(1)).save(newGroup);
        Mockito.verify(groupMapper, Mockito.times(1)).updateEntity(group, groupDto);
        Assert.assertEquals(newGroup, update);
    }

    @Test
    public void deleteGroupTest() {
        groupService.delete(1L);

        Mockito.verify(groupRepo, Mockito.times(1)).deleteById(1L);
    }
}
