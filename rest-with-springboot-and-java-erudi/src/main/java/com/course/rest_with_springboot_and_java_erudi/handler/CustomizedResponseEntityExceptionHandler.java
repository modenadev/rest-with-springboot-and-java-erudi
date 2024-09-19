package com.course.rest_with_springboot_and_java_erudi.handler;

import com.course.rest_with_springboot_and_java_erudi.excpetions.ExcpectionResponse;
import com.course.rest_with_springboot_and_java_erudi.excpetions.UnsupportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcpectionResponse> handleAllExcpetions(Exception ex, WebRequest request) {
        ExcpectionResponse excpectionResponse = new ExcpectionResponse(new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(excpectionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedMathOperationException.class)
    public final ResponseEntity<ExcpectionResponse> handleBadRequestExcpetions(Exception ex, WebRequest request) {
        ExcpectionResponse excpectionResponse = new ExcpectionResponse(new Date(),
                ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(excpectionResponse, HttpStatus.BAD_REQUEST);
    }

}