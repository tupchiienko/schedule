package com.example.schedule.mapper;

import com.example.schedule.data.dto.LessonDto;
import com.example.schedule.data.model.Lesson;
import com.example.schedule.service.ClassroomService;
import com.example.schedule.service.GroupService;
import com.example.schedule.service.SubjectService;
import com.example.schedule.service.TeacherService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class LessonMapper implements BaseMapper<Lesson, LessonDto> {

    @Autowired
    protected SubjectService subjectService;

    @Autowired
    protected TeacherService teacherService;

    @Autowired
    protected ClassroomService classroomService;

    @Autowired
    protected GroupService groupService;

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "subject", expression = "java(subjectService.findById(dto.getSubjectId()))")
    @Mapping(target = "teacher", expression = "java(teacherService.findById(dto.getTeacherId()))")
    @Mapping(target = "classroom", expression = "java(classroomService.findById(dto.getClassroomId()))")
    @Mapping(target = "groups", expression = "java(groupService.findAllById(dto.getGroupsIdList()))")
    public abstract Lesson mapToEntity(LessonDto dto);

    @Override
    @Mapping(target = "subject", expression = "java(subjectService.findById(dto.getSubjectId()))")
    @Mapping(target = "teacher", expression = "java(teacherService.findById(dto.getTeacherId()))")
    @Mapping(target = "classroom", expression = "java(classroomService.findById(dto.getClassroomId()))")
    @Mapping(target = "groups", expression = "java(groupService.findAllById(dto.getGroupsIdList()))")
    @Mapping(target = "dayOfWeek", source = "dto.dayOfWeek")
    @Mapping(target = "time", source = "dto.time")
    public abstract Lesson updateEntity(Lesson entity, LessonDto dto);

}
