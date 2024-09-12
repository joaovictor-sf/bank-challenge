package com.joaovictor.bank.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MaxAccountNumberExcepetion extends RuntimeException {
    public MaxAccountNumberExcepetion(String message) {
        super(message);
    }
}
