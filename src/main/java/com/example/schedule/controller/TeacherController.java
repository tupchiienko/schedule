package com.example.schedule.controller;

import com.example.schedule.data.validation.CreateInfo;
import com.example.schedule.data.validation.UpdateInfo;
import com.example.schedule.data.dto.TeacherDto;
import com.example.schedule.data.model.Teacher;
import com.example.schedule.service.TeacherService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@AllArgsConstructor
public class TeacherController {

    private TeacherService teacherService;

    @PostMapping(
            value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Teacher create(@RequestBody @Validated(CreateInfo.class) TeacherDto teacherDto) {
        return teacherService.create(teacherDto);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Teacher getById(@PathVariable Long id) {
        return teacherService.findById(id);
    }

    @GetMapping(
            value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Teacher> getAll() {
        return teacherService.findAll();
    }

    @PutMapping(
            value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Teacher update(@PathVariable Long id, @RequestBody @Validated(UpdateInfo.class) TeacherDto teacherDto) {
        return teacherService.update(id, teacherDto);
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }
}
