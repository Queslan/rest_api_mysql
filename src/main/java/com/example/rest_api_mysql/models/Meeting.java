package com.example.rest_api_mysql.models;

import com.example.rest_api_mysql.enums.Priority;
import com.example.rest_api_mysql.enums.Type;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
public class Meeting {
    private @Id @GeneratedValue(strategy= GenerationType.AUTO) Long id;
    private Date date;
    private Time time;
    @Enumerated(EnumType.STRING)
    private Type type;
    @Enumerated(EnumType.STRING)
    private Priority priority;

    public Meeting() {
    }

    public Meeting(Date date, Time time, Type type, Priority priority) {
        this.date = date;
        this.time = time;
        this.type = type;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
