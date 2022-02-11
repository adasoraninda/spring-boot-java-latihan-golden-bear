package com.contohdi.demo.controller;

import com.contohdi.demo.model.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(value = {NoHandlerFoundException.class})
    public ResponseEntity<String> handleNoPath(NoHandlerFoundException e) {
        e.printStackTrace();
        System.out.println("jalan");

        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<BaseResponse<String>> entityNotFoundEx(
            EntityNotFoundException ex
    ) {
        var body = new BaseResponse<>(
                400,
                "Gagal",
                ex.getMessage()
        );

        return ResponseEntity.badRequest()
                .body(body);
    }


}
