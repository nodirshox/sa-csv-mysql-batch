package com.sa.csv.batch.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseDTO {
    private String message;
    private Boolean success;
}
