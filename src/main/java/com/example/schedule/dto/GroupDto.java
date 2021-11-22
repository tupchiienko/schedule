package com.example.schedule.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {

    @NotNull
    @Pattern(
            regexp = "^([A-Za-z][A-Za-z]-[0-9][0-9])$",
            message = "Invalid code format (example: xx-00, XX-00, Xx-00, xX-00)"
    )
    private String groupCode;
}
