package com.example.notificationapp;

import java.io.Serializable;

public class Alarm implements Serializable {
    private int id;
    private int hour, min;
    private boolean status;
    private String name;

    public Alarm() {
    }

    public Alarm(int hour, int min, boolean status, String name) {
        this.hour = hour;
        this.min = min;
        this.status = status;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String h, m, format;
        if (hour > 12) {
            h = (hour - 12) + "";
            format = "PM";
        } else if (hour == 0) {
            h = "12";
            format = "AM";
        } else if (hour == 12) {
            h = "12";
            format = "PM";
        } else {
            h = hour + "";
            format = "AM";
        }
        if (min < 10) {
            m = "0" + min;
        } else {
            m = "" + min;
        }
        return h + ":" + m + format;
    }
}