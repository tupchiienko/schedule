package com.example.schedule.mapper;

import com.example.schedule.dto.GroupDto;
import com.example.schedule.model.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper extends BaseMapper<Group, GroupDto> {

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code", source = "dto.groupCode")
    Group mapToEntity(GroupDto dto);

    @Override
    @Mapping(target = "code", source = "dto.groupCode")
    Group updateEntity(Group entity, GroupDto dto);
}
