package com.example.rest_api_mysql.controllers;

import com.example.rest_api_mysql.models.Meeting;
import com.example.rest_api_mysql.repositories.MeetingRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
public class MeetingController {

    private final MeetingRepository meetingRepository;

    public MeetingController(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    @GetMapping("/meetings")
    public Iterable<Meeting> all() {
        return meetingRepository.findAll();
    }

    @GetMapping("/meetings/{id}")
    public Optional<Meeting> findMeetingById(@PathVariable Long id) {
        return meetingRepository.findById(id);
    }

    @GetMapping("meetings/{date}/{time}")
    public List<Meeting> findMeetingByDate(@PathVariable Date date, @PathVariable Time time) {
        return meetingRepository.findMeetingByDateAndTime(date, time);
    }
}
