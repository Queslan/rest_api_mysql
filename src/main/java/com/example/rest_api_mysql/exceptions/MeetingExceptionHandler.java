package com.example.rest_api_mysql.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MeetingExceptionHandler {
   @ResponseBody
    @ExceptionHandler(MeetingNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String meetingNotFoundHandler(MeetingNotFoundException e) {
       return e.getMessage();
   }
}
