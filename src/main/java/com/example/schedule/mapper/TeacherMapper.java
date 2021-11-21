package com.example.schedule.mapper;

import com.example.schedule.dto.TeacherDto;
import com.example.schedule.model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDto> {
}
