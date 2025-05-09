package com.evalsup.crud.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Getter @AllArgsConstructor
public class ErrorResponseDto {

    private int status;
    private String error;
    private String message;
    private LocalDateTime errorTime;
}
