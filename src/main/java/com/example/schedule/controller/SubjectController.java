package com.example.schedule.controller;

import com.example.schedule.data.validation.CreateInfo;
import com.example.schedule.data.validation.UpdateInfo;
import com.example.schedule.data.dto.SubjectDto;
import com.example.schedule.data.model.Subject;
import com.example.schedule.service.SubjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@AllArgsConstructor
public class SubjectController {

    private SubjectService subjectService;

    @PostMapping(
            value = "/new",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Subject create(@RequestBody @Validated(CreateInfo.class) SubjectDto subjectDto) {
        return subjectService.create(subjectDto);
    }

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Subject getById(@PathVariable Long id) {
        return subjectService.findById(id);
    }

    @GetMapping(
            value = "/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Subject> getAll() {
        return subjectService.findAll();
    }

    @PutMapping(
            value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Subject update(@PathVariable Long id, @RequestBody @Validated(UpdateInfo.class) SubjectDto subjectDto) {
        return subjectService.update(id, subjectDto);
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public void delete(@PathVariable Long id) {
        subjectService.delete(id);
    }
}
