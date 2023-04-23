package com.example.Medical.Records.v10.entity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TeacherNotFoundException extends RuntimeException {
//    TODO implement for all entities if needed
    public TeacherNotFoundException(String message) {
        super(message);
    }
}
