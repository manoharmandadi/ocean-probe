package com.maverick.probe.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String errorClass;
    private String message;

    public ErrorResponse(String error, String message){
        this.errorClass = error;
        this.message = message;
    }
}
