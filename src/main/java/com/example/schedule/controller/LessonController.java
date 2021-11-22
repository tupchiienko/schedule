package com.example.schedule.controller;

import com.example.schedule.config.FullInfo;
import com.example.schedule.dto.LessonDto;
import com.example.schedule.model.Lesson;
import com.example.schedule.service.LessonService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Lesson create(@RequestBody @Validated(FullInfo.class) LessonDto lessonDto) {
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
    public Lesson update(@PathVariable Long id, @RequestBody @Valid LessonDto lessonDto) {
        return lessonService.update(id, lessonDto);
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public void delete(@PathVariable Long id) {
        lessonService.delete(id);
    }
}
