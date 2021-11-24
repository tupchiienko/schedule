package com.example.schedule;

import com.example.schedule.data.dto.ClassroomDto;
import com.example.schedule.mapper.ClassroomMapper;
import com.example.schedule.data.model.Classroom;
import com.example.schedule.repo.ClassroomRepo;
import com.example.schedule.service.impl.ClassroomServiceImpl;
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
public class ClassroomServiceImplUnitTest {

    @Mock
    private ClassroomRepo classroomRepo;
    @Mock
    private ClassroomMapper classroomMapper;

    @InjectMocks
    private ClassroomServiceImpl classroomService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createClassroomTest() {
        ClassroomDto classroomDto = new ClassroomDto(1, 32);
        Classroom classroom = new Classroom(1, 32);

        Mockito.when(classroomMapper.mapToEntity(classroomDto)).thenReturn(classroom);
        Mockito.when(classroomRepo.save(classroom)).thenReturn(classroom);

        Classroom created = classroomService.create(classroomDto);

        Mockito.verify(classroomMapper, Mockito.times(1)).mapToEntity(classroomDto);
        Mockito.verify(classroomRepo, Mockito.times(1)).save(classroom);
        Assert.assertEquals(classroom, created);
    }

    @Test
    public void findClassroomByIdTest() {
        Classroom classroom = new Classroom(4, 51);

        Mockito.when(classroomRepo.findById(1L)).thenReturn(Optional.of(classroom));
        Mockito.when(classroomRepo.findById(2L)).thenReturn(Optional.empty());

        Classroom byId = classroomService.findById(1L);

        Mockito.verify(classroomRepo, Mockito.times(1)).findById(1L);
        Assert.assertEquals(classroom, byId);
        Assert.assertThrows(NoSuchElementException.class, () -> classroomService.findById(2L));
    }

    @Test
    public void findAllClassroomsTest() {
        Classroom classroom1 = new Classroom(12, 4);
        Classroom classroom2 = new Classroom(6, 23);
        Classroom classroom3 = new Classroom(16, 158);
        List<Classroom> classrooms = List.of(classroom1, classroom2, classroom3);

        Mockito.when(classroomRepo.findAll()).thenReturn(classrooms);

        List<Classroom> all = classroomService.findAll();

        Mockito.verify(classroomRepo, Mockito.times(1)).findAll();
        Assert.assertEquals(classrooms, all);
    }

    @Test
    public void updateClassroomTest() {
        Classroom classroom = new Classroom(1, 11);
        ClassroomDto classroomDto = new ClassroomDto(null, 53);
        Classroom newClassroom = new Classroom(1, 53);

        Mockito.when(classroomRepo.findById(1L)).thenReturn(Optional.of(classroom));
        Mockito.when(classroomMapper.updateEntity(classroom, classroomDto)).thenReturn(newClassroom);
        Mockito.when(classroomRepo.save(newClassroom)).thenReturn(newClassroom);

        Classroom update = classroomService.update(1L, classroomDto);

        Mockito.verify(classroomRepo, Mockito.times(1)).findById(1L);
        Mockito.verify(classroomRepo, Mockito.times(1)).save(newClassroom);
        Mockito.verify(classroomMapper, Mockito.times(1)).updateEntity(classroom, classroomDto);
        Assert.assertEquals(newClassroom, update);
    }

    @Test
    public void deleteClassroomTest() {
        classroomService.delete(1L);

        Mockito.verify(classroomRepo, Mockito.times(1)).deleteById(1L);
    }
}
