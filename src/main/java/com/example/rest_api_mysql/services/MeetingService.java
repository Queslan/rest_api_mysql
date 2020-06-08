package com.example.rest_api_mysql.services;

import com.example.rest_api_mysql.enums.Priority;
import com.example.rest_api_mysql.enums.Type;
import com.example.rest_api_mysql.exceptions.MeetingNotFoundException;
import com.example.rest_api_mysql.models.Meeting;
import com.example.rest_api_mysql.repositories.MeetingRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class MeetingService {
    private final MeetingRepository meetingRepository;

    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }
    public Iterable<Meeting> findAllMeetings() {
        return meetingRepository.findAll();
    }
    public Optional<Meeting> findMeetingById(Long id) {
        return meetingRepository.findById(id);
    }
    public List<Meeting> findMeetingByDateAndTime(Date date, Time time) {
        return meetingRepository.findMeetingByDateAndTime(date, time);
    }
    public Meeting addMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }
    public Meeting changeMeeting(Meeting meeting) {
        return meetingRepository.save(meeting);
    }
    public void deleteMeeting(Long id) {
       try {
           meetingRepository.deleteById(id);
       } catch (Exception e) {
           throw new MeetingNotFoundException(id);
       }
    }
    public List<Meeting> sortMeetingsByDate() {
        return meetingRepository.findAllByOrderByDate();
    }
    public List<Priority> getAllPriorities() {
        return  Arrays.asList(Priority.values());
    }
    public List<Type> getAllTypes() {
        return  Arrays.asList(Type.values());
    }
}
