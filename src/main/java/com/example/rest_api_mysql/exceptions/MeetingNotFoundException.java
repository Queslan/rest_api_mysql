package com.example.rest_api_mysql.exceptions;

public class MeetingNotFoundException extends RuntimeException{
    public MeetingNotFoundException(Long id) {
        super("Could not find meeting " + id);
    }
}
