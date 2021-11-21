package com.example.schedule.mapper;

import com.example.schedule.dto.SubjectDto;
import com.example.schedule.model.Subject;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubjectMapper extends BaseMapper<Subject, SubjectDto> {
}
