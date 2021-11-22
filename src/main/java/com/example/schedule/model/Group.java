package com.example.schedule.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "groups")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Group extends BaseEntity {

    @Column(name = "code", nullable = false, unique = true)
    private String code;

}
