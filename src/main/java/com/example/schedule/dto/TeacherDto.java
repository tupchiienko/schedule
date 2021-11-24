package com.example.schedule.dto;

import com.example.schedule.data.validation.CreateInfo;
import com.example.schedule.data.validation.UpdateInfo;
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

    @NotNull(groups = CreateInfo.class)
    @NotEmpty(groups = CreateInfo.class)
    @Size(max = 32, groups = {CreateInfo.class, UpdateInfo.class})
    private String firstName;

    @NotNull(groups = CreateInfo.class)
    @NotEmpty(groups = CreateInfo.class)
    @Size(max = 32, groups = {CreateInfo.class, UpdateInfo.class})
    private String lastName;
}
