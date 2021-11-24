package com.example.schedule.data.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {

    private Integer statusCode;
    private Timestamp timestamp;
    private List<String> errors;
}
