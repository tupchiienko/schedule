package com.example.schedule.mapper;

import com.example.schedule.dto.ClassroomDto;
import com.example.schedule.model.Classroom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassroomMapper extends BaseMapper<Classroom, ClassroomDto> {
}
