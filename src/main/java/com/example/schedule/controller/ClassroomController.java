package com.example.schedule.controller;

import com.example.schedule.data.validation.CreateInfo;
import com.example.schedule.data.validation.UpdateInfo;
import com.example.schedule.data.dto.ClassroomDto;
import com.example.schedule.data.model.Classroom;
import com.example.schedule.service.ClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
@AllArgsConstructor
public class ClassroomController {

    private ClassroomService classroomService;

    @PostMapping(
            value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Classroom create(@RequestBody @Validated(CreateInfo.class) ClassroomDto classroomDto) {
        return classroomService.create(classroomDto);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Classroom getById(@PathVariable Long id) {
        return classroomService.findById(id);
    }

    @GetMapping(
            value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Classroom> getAll() {
        return classroomService.findAll();
    }

    @PutMapping(
            value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Classroom update(@PathVariable Long id, @RequestBody @Validated(UpdateInfo.class) ClassroomDto classroomDto) {
        return classroomService.update(id, classroomDto);
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public void delete(@PathVariable Long id) {
        classroomService.delete(id);
    }
}
