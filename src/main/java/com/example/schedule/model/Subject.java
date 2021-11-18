package com.example.schedule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "subjects")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Subject extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

}
