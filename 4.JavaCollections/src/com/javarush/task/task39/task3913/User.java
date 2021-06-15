package com.javarush.task.task39.task3913;

import java.util.Date;

public class User {
    private String ip;
    private String userName;
    private Date date;
    private Event event;
    private int task;
    private Status status;

    public User(String ip, String userName, Date date, Event event, int task, Status status) {
        this.ip = ip;
        this.userName = userName;
        this.date = date;
        this.event = event;
        this.task = task;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public String getUserName() {
        return userName;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public int getTask() {
        return task;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "User{" +
                "ip='" + ip + '\'' +
                ", user='" + userName + '\'' +
                ", date=" + date +
                ", event=" + event +
                ", number='" + task + '\'' +
                ", status=" + status +
                '}';
    }
}
