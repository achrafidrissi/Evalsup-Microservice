package com.evalsup.crud.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResponseDto<T> {
    private String statusCode;
    private String statusMsg;
    private T data;
}
