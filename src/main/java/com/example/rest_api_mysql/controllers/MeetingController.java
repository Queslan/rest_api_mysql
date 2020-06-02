package com.example.rest_api_mysql.controllers;

import com.example.rest_api_mysql.services.MeetingService;
import com.example.rest_api_mysql.models.Meeting;
import com.example.rest_api_mysql.repositories.MeetingRepository;
import enums.Priority;
import enums.Type;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
public class MeetingController {

    private final MeetingRepository meetingRepository;
    private final MeetingService meetingService;

    public MeetingController(MeetingRepository meetingRepository, MeetingService meetingService) {
        this.meetingRepository = meetingRepository;
        this.meetingService = meetingService;
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

    @PostMapping("/meetings")
    public Meeting addMeeting(@RequestBody Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @PutMapping("/meetings")
    public Meeting changeMeeting(@RequestBody Meeting meeting) {
        return meetingRepository.save(meeting);
    }

    @DeleteMapping("/meetings/{id}")
    public String deleteMeeting(@PathVariable Long id) {
        meetingRepository.deleteById(id);
        return "Deleted.";
    }
    @GetMapping("/meetings/priorities")
    public List<Priority> getAllPriorities()  {
        return meetingService.getAllPriorities();
    }
    @GetMapping("/meetings/types")
    public List<Type> getAllTypes()  {
        return meetingService.getAllTypes();
    }

    @GetMapping("/meetings/sorted-by-date")
    public List<Meeting> sortMeetingsByDate() {
        return meetingRepository.sortMeetingsByDate();
    }
}
