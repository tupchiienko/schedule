package com.example.schedule;

import com.example.schedule.data.dto.TeacherDto;
import com.example.schedule.mapper.TeacherMapper;
import com.example.schedule.data.model.Teacher;
import com.example.schedule.repo.TeacherRepo;
import com.example.schedule.service.impl.TeacherServiceImpl;
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
public class TeacherServiceImplUnitTest {

    @Mock
    private TeacherRepo teacherRepo;
    @Mock
    private TeacherMapper teacherMapper;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createTeacherTest() {
        TeacherDto teacherDto = new TeacherDto("Ivan", "Ivanov");
        Teacher teacher = new Teacher("Ivan", "Ivanov");

        Mockito.when(teacherMapper.mapToEntity(teacherDto)).thenReturn(teacher);
        Mockito.when(teacherRepo.save(teacher)).thenReturn(teacher);

        Teacher created = teacherService.create(teacherDto);

        Mockito.verify(teacherMapper, Mockito.times(1)).mapToEntity(teacherDto);
        Mockito.verify(teacherRepo, Mockito.times(1)).save(teacher);
        Assert.assertEquals(teacher, created);
    }

    @Test
    public void findTeacherByIdTest() {
        Teacher teacher = new Teacher("Ivan", "Ivanov");

        Mockito.when(teacherRepo.findById(1L)).thenReturn(Optional.of(teacher));
        Mockito.when(teacherRepo.findById(2L)).thenReturn(Optional.empty());

        Teacher byId = teacherService.findById(1L);

        Mockito.verify(teacherRepo, Mockito.times(1)).findById(1L);
        Assert.assertEquals(teacher, byId);
        Assert.assertThrows(NoSuchElementException.class, () -> teacherService.findById(2L));
    }

    @Test
    public void findAllTeachersTest() {
        Teacher teacher1 = new Teacher("Ivan", "Ivanov");
        Teacher teacher2 = new Teacher("Vlodymyr", "Petrov");
        Teacher teacher3 = new Teacher("Katya", "Andriienko");
        List<Teacher> teachers = List.of(teacher1, teacher2, teacher3);

        Mockito.when(teacherRepo.findAll()).thenReturn(teachers);

        List<Teacher> all = teacherService.findAll();

        Mockito.verify(teacherRepo, Mockito.times(1)).findAll();
        Assert.assertEquals(teachers, all);
    }

    @Test
    public void updateTeacherTest() {
        Teacher teacher = new Teacher("Ivan", "Ivanov");
        TeacherDto teacherDto = new TeacherDto(null, "Ivanenko");
        Teacher newTeacher = new Teacher("Ivan", "Ivanenko");

        Mockito.when(teacherRepo.findById(1L)).thenReturn(Optional.of(teacher));
        Mockito.when(teacherMapper.updateEntity(teacher, teacherDto)).thenReturn(newTeacher);
        Mockito.when(teacherRepo.save(newTeacher)).thenReturn(newTeacher);

        Teacher update = teacherService.update(1L, teacherDto);

        Mockito.verify(teacherRepo, Mockito.times(1)).findById(1L);
        Mockito.verify(teacherRepo, Mockito.times(1)).save(newTeacher);
        Mockito.verify(teacherMapper, Mockito.times(1)).updateEntity(teacher, teacherDto);
        Assert.assertEquals(newTeacher, update);
    }

    @Test
    public void deleteTeacherTest() {
        teacherService.delete(1L);

        Mockito.verify(teacherRepo, Mockito.times(1)).deleteById(1L);
    }
}
