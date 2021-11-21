package com.example.schedule.mapper;

import com.example.schedule.model.BaseEntity;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

public interface BaseMapper<E extends BaseEntity, D> {

    @Mapping(target = "id", ignore = true)
    E mapToEntity(D dto);

    @Mapping(target = "id", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    E updateEntity(@MappingTarget E entity, D dto);
}
