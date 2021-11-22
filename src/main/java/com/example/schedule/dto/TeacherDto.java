package com.example.schedule.dto;

import com.example.schedule.config.FullInfo;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {

    @NotNull(groups = FullInfo.class)
    @NotEmpty
    @Size(max = 32)
    private String firstName;

    @NotNull(groups = FullInfo.class)
    @NotEmpty
    @Size(max = 32)
    private String lastName;
}
