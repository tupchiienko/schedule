package com.example.schedule.service;

import com.example.schedule.model.BaseEntity;

import java.util.List;

public interface CrudService<ID, E extends BaseEntity, D> {

    E create(D dto);

    E findById(ID id);

    List<E> findAll();

    List<E> findAllById(List<ID> ids);

    E update(ID id, D dto);

    void delete(ID id);

}
