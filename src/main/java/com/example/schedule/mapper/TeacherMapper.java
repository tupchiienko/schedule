package com.example.schedule.mapper;

import com.example.schedule.data.dto.TeacherDto;
import com.example.schedule.data.model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDto> {
}
