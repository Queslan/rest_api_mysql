package com.example.rest_api_mysql.repositories;

import com.example.rest_api_mysql.models.Meeting;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {
    public List<Meeting> findMeetingByDateAndTime(Date date, Time time);
    public List<Meeting> findAllByOrderByDate();
}
