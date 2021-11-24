package com.example.schedule;

import com.example.schedule.data.dto.StudentDto;
import com.example.schedule.mapper.StudentMapper;
import com.example.schedule.data.model.Group;
import com.example.schedule.data.model.Student;
import com.example.schedule.repo.StudentRepo;
import com.example.schedule.service.impl.StudentServiceImpl;
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
public class StudentServiceImplUnitTest {

    @Mock
    private StudentRepo studentRepo;
    @Mock
    private StudentMapper studentMapper;

    @InjectMocks
    private StudentServiceImpl studentService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createStudentTest() {
        StudentDto studentDto = new StudentDto("Ivan", "Ivanov", 1L);
        Student student = new Student("Ivan", "Ivanov", new Group("AI-01"));

        Mockito.when(studentMapper.mapToEntity(studentDto)).thenReturn(student);
        Mockito.when(studentRepo.save(student)).thenReturn(student);

        Student created = studentService.create(studentDto);

        Mockito.verify(studentMapper, Mockito.times(1)).mapToEntity(studentDto);
        Mockito.verify(studentRepo, Mockito.times(1)).save(student);
        Assert.assertEquals(student, created);
    }

    @Test
    public void findStudentByIdTest() {
        Student student = new Student("Ivan", "Ivanov", new Group("AI-01"));

        Mockito.when(studentRepo.findById(1L)).thenReturn(Optional.of(student));
        Mockito.when(studentRepo.findById(2L)).thenReturn(Optional.empty());

        Student byId = studentService.findById(1L);

        Mockito.verify(studentRepo, Mockito.times(1)).findById(1L);
        Assert.assertEquals(student, byId);
        Assert.assertThrows(NoSuchElementException.class, () -> studentService.findById(2L));
    }

    @Test
    public void findAllStudentsTest() {
        Student student1 = new Student("Ivan", "Ivanov", new Group("AI-01"));
        Student student2 = new Student("Vlodymyr", "Petrov", new Group("AI-02"));
        Student student3 = new Student("Katya", "Andriienko", new Group("AI-03"));
        List<Student> students = List.of(student1, student2, student3);

        Mockito.when(studentRepo.findAll()).thenReturn(students);

        List<Student> all = studentService.findAll();

        Mockito.verify(studentRepo, Mockito.times(1)).findAll();
        Assert.assertEquals(students, all);
    }

    @Test
    public void updateStudentTest() {
        Student student = new Student("Ivan", "Ivanov", new Group("AI-01"));
        StudentDto studentDto = new StudentDto(null, null, 1L);
        Student newStudent = new Student("Ivan", "Ivanov", new Group("AI-02"));

        Mockito.when(studentRepo.findById(1L)).thenReturn(Optional.of(student));
        Mockito.when(studentMapper.updateEntity(student, studentDto)).thenReturn(newStudent);
        Mockito.when(studentRepo.save(newStudent)).thenReturn(newStudent);

        Student update = studentService.update(1L, studentDto);

        Mockito.verify(studentRepo, Mockito.times(1)).findById(1L);
        Mockito.verify(studentRepo, Mockito.times(1)).save(newStudent);
        Mockito.verify(studentMapper, Mockito.times(1)).updateEntity(student, studentDto);
        Assert.assertEquals(newStudent, update);
    }

    @Test
    public void deleteStudentTest() {
        studentService.delete(1L);

        Mockito.verify(studentRepo, Mockito.times(1)).deleteById(1L);
    }
}
