package com.example.schedule.controller;

import com.example.schedule.data.validation.CreateInfo;
import com.example.schedule.data.validation.UpdateInfo;
import com.example.schedule.data.dto.LessonDto;
import com.example.schedule.data.model.Lesson;
import com.example.schedule.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/lessons")
@AllArgsConstructor
public class LessonController {

    private LessonService lessonService;

    @PostMapping(
            value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Lesson create(@RequestBody @Validated(CreateInfo.class) LessonDto lessonDto) {
        return lessonService.create(lessonDto);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Lesson getById(@PathVariable Long id) {
        return lessonService.findById(id);
    }

    @GetMapping(
            value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Lesson> getAll() {
        return lessonService.findAll();
    }

    @PutMapping(
            value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Lesson update(@PathVariable Long id, @RequestBody @Validated(UpdateInfo.class) LessonDto lessonDto) {
        return lessonService.update(id, lessonDto);
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public void delete(@PathVariable Long id) {
        lessonService.delete(id);
    }

    @GetMapping(
            value = "/list/group",
            params = {"groupCode", "dayOfWeek"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Lesson> getAllByGroupCodeAndDayOfWeek(@RequestParam String groupCode, @RequestParam DayOfWeek dayOfWeek) {
        return lessonService.findAllByGroupCodeAndDayOfWeek(groupCode, dayOfWeek);
    }

    @GetMapping(
            value = "/list/teacher",
            params = {"firstName", "lastName", "dayOfWeek"},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Lesson> getAllByTeacherAndDayOfWeek(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam DayOfWeek dayOfWeek
    ) {
        return lessonService.findAllByTeacherAndDayOfWeek(firstName, lastName, dayOfWeek);
    }
}
