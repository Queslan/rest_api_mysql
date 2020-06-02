package com.example.rest_api_mysql.services;

import enums.Priority;
import enums.Type;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class MeetingService {
    public List<Priority> getAllPriorities() {
        return  Arrays.asList(Priority.values());
    }
    public List<Type> getAllTypes() {
        return  Arrays.asList(Type.values());
    }
}
