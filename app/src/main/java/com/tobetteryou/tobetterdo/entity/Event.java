package com.tobetteryou.tobetterdo.entity;

import java.io.Serializable;

public class Event implements Serializable {
    private int event_id;
    private String event_name;

    public Event() {
    }

    public Event(int event_id, String event_name) {
        this.event_id = event_id;
        this.event_name = event_name;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }
}
