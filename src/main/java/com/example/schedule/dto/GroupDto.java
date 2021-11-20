package com.example.schedule.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class GroupDto {

    @NotNull
    @Pattern(
            regexp = "^([A-Za-z][A-Za-z]-[0-9][0-9])$",
            message = "Invalid code format (example: xx-00, XX-00, Xx-00, xX-00)"
    )
    private String groupCode;
}
