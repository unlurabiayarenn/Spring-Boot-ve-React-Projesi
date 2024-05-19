package com.rabiayarenn.api.controller;

//bu class sayesinde bir exception fırlattığımızda bu class bunu handle edecek ve mesajı ile beraber hatayı yakalamış olucaz

import com.rabiayarenn.api.common.GeneralException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionController {
    @ExceptionHandler(value= GeneralException.class)
    public ResponseEntity<ErrorMessage> exception(GeneralException e) {
        return new ResponseEntity<>(new ErrorMessage(e.getMessage()), HttpStatus.BAD_REQUEST);

    }
}

@Getter
@Setter
@AllArgsConstructor
class ErrorMessage{
    private String errorMessage;
}
