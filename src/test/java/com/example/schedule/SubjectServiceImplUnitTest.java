package com.example.schedule;

import com.example.schedule.data.dto.SubjectDto;
import com.example.schedule.mapper.SubjectMapper;
import com.example.schedule.data.model.Subject;
import com.example.schedule.repo.SubjectRepo;
import com.example.schedule.service.impl.SubjectServiceImpl;
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
public class SubjectServiceImplUnitTest {

    @Mock
    private SubjectRepo subjectRepo;
    @Mock
    private SubjectMapper subjectMapper;

    @InjectMocks
    private SubjectServiceImpl subjectService;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createSubjectTest() {
        SubjectDto subjectDto = new SubjectDto("Programming");
        Subject subject = new Subject("Programming");

        Mockito.when(subjectMapper.mapToEntity(subjectDto)).thenReturn(subject);
        Mockito.when(subjectRepo.save(subject)).thenReturn(subject);

        Subject created = subjectService.create(subjectDto);

        Mockito.verify(subjectMapper, Mockito.times(1)).mapToEntity(subjectDto);
        Mockito.verify(subjectRepo, Mockito.times(1)).save(subject);
        Assert.assertEquals(subject, created);
    }

    @Test
    public void findSubjectByIdTest() {
        Subject subject = new Subject("Programming");

        Mockito.when(subjectRepo.findById(1L)).thenReturn(Optional.of(subject));
        Mockito.when(subjectRepo.findById(2L)).thenReturn(Optional.empty());

        Subject byId = subjectService.findById(1L);

        Mockito.verify(subjectRepo, Mockito.times(1)).findById(1L);
        Assert.assertEquals(subject, byId);
        Assert.assertThrows(NoSuchElementException.class, () -> subjectService.findById(2L));
    }

    @Test
    public void findAllSubjectsTest() {
        Subject subject1 = new Subject("Programming");
        Subject subject2 = new Subject("Math");
        Subject subject3 = new Subject("History");
        List<Subject> students = List.of(subject1, subject2, subject3);

        Mockito.when(subjectRepo.findAll()).thenReturn(students);

        List<Subject> all = subjectService.findAll();

        Mockito.verify(subjectRepo, Mockito.times(1)).findAll();
        Assert.assertEquals(students, all);
    }

    @Test
    public void updateSubjectTest() {
        Subject subject = new Subject("Programming");
        SubjectDto subjectDto = new SubjectDto("OOP");
        Subject newSubject = new Subject("OOP");

        Mockito.when(subjectRepo.findById(1L)).thenReturn(Optional.of(subject));
        Mockito.when(subjectMapper.updateEntity(subject, subjectDto)).thenReturn(newSubject);
        Mockito.when(subjectRepo.save(newSubject)).thenReturn(newSubject);

        Subject update = subjectService.update(1L, subjectDto);

        Mockito.verify(subjectRepo, Mockito.times(1)).findById(1L);
        Mockito.verify(subjectRepo, Mockito.times(1)).save(newSubject);
        Mockito.verify(subjectMapper, Mockito.times(1)).updateEntity(subject, subjectDto);
        Assert.assertEquals(newSubject, update);
    }

    @Test
    public void deleteSubjectTest() {
        subjectService.delete(1L);

        Mockito.verify(subjectRepo, Mockito.times(1)).deleteById(1L);
    }
}
