package com.dataart.vgaydamakin.finalproject.controller;

import com.dataart.vgaydamakin.finalproject.exceptions.ArticleFormatException;
import com.dataart.vgaydamakin.finalproject.exceptions.InvalidZipContentException;
import com.dataart.vgaydamakin.finalproject.exceptions.MyFileNotFoundException;
import com.dataart.vgaydamakin.finalproject.exceptions.NotAZipFileException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDTO handleRuntimeException(RuntimeException e) {
        return new ErrorDTO(e.getMessage());
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDTO handleIOException(IOException e) {
        return new ErrorDTO(e.getMessage());
    }

    @ExceptionHandler(NotAZipFileException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public ErrorDTO NotAZipFileException(RuntimeException e) {
        return new ErrorDTO(e.getMessage());
    }

    @ExceptionHandler(InvalidZipContentException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public ErrorDTO InvalidZipContentException(RuntimeException e) {
        return new ErrorDTO(e.getMessage());
    }

    @ExceptionHandler(MyFileNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public ErrorDTO MyFileNotFoundException(RuntimeException e) {
        return new ErrorDTO(e.getMessage());
    }

    @ExceptionHandler(ArticleFormatException.class)
    @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public ErrorDTO ArticleFormatException(RuntimeException e) {
        return new ErrorDTO(e.getMessage());
    }

    @Data
    @AllArgsConstructor
    public class ErrorDTO {
        private String message;
    }
}
