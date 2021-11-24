package com.example.schedule.mapper;

import com.example.schedule.data.dto.ClassroomDto;
import com.example.schedule.data.model.Classroom;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClassroomMapper extends BaseMapper<Classroom, ClassroomDto> {
}
