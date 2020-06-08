package com.example.rest_api_mysql.controllers;

import com.example.rest_api_mysql.services.MeetingService;
import com.example.rest_api_mysql.models.Meeting;
import com.example.rest_api_mysql.enums.Priority;
import com.example.rest_api_mysql.enums.Type;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Optional;

@RestController
public class MeetingController {
    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/meetings")
    public Iterable<Meeting> all() {
        return meetingService.findAllMeetings();
    }

    @GetMapping("/meetings/{id}")
    public Optional<Meeting> findMeetingById(@PathVariable Long id) {
        return meetingService.findMeetingById(id);
    }

    @GetMapping("meetings/{date}/{time}")
    public List<Meeting> findMeetingByDate(@PathVariable Date date, @PathVariable Time time) {
        return meetingService.findMeetingByDateAndTime(date, time);
    }

    @PostMapping("/meetings")
    public Meeting addMeeting(@RequestBody Meeting meeting) {
        return meetingService.addMeeting(meeting);
    }

    @PutMapping("/meetings")
    public Meeting changeMeeting(@RequestBody Meeting meeting) {
        return meetingService.changeMeeting(meeting);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Meeting does not exist")
    @DeleteMapping("/meetings/{id}")
    public void deleteMeeting(@PathVariable Long id) {
         meetingService.deleteMeeting(id);
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
        return meetingService.sortMeetingsByDate();
    }
}
