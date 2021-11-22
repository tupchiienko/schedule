package com.example.schedule.controller;

import com.example.schedule.config.FullInfo;
import com.example.schedule.dto.LessonDto;
import com.example.schedule.dto.StudentDto;
import com.example.schedule.model.Lesson;
import com.example.schedule.model.Student;
import com.example.schedule.service.LessonService;
import com.example.schedule.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping(
            value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Student create(@RequestBody @Validated(FullInfo.class) StudentDto studentDto) {
        return studentService.create(studentDto);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Student getById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @GetMapping(
            value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Student> getAll() {
        return studentService.findAll();
    }

    @PutMapping(
            value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Student update(@PathVariable Long id, @RequestBody @Valid StudentDto studentDto) {
        return studentService.update(id, studentDto);
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
