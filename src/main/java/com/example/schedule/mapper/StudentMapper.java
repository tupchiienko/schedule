package com.example.schedule.mapper;

import com.example.schedule.data.dto.StudentDto;
import com.example.schedule.data.model.Student;
import com.example.schedule.repo.GroupRepo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class StudentMapper implements BaseMapper<Student, StudentDto> {

    @Autowired
    protected GroupRepo groupService;

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "group", expression = "java(groupService.findById(dto.getGroupId()).orElseThrow())")
    public abstract Student mapToEntity(StudentDto dto);

    @Override
    @Mapping(target = "group", expression = "java(groupService.findById(dto.getGroupId()).orElseThrow())")
    public Student updateEntity(Student entity, StudentDto dto) {
        return null;
    }
}
