package com.company.product.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class ExceptionResponse {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String path;

}
