package com.evalsup.crud.DTO;


import lombok.*;

@Data
@NoArgsConstructor @AllArgsConstructor
public class ResponseDto<T> {
    private String statusCode;
    private String statusMsg;
    private T data;
}