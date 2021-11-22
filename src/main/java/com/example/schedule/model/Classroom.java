package com.example.schedule.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "classrooms")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Classroom extends BaseEntity {

    @Column(name = "pavilion_number", nullable = false)
    private int pavilionNumber;

    @Column(name = "room_number", nullable = false)
    private int roomNumber;

}
