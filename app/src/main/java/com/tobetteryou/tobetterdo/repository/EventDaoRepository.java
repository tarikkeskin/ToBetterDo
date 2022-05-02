package com.tobetteryou.tobetterdo.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.tobetteryou.tobetterdo.entity.Event;

import java.util.ArrayList;
import java.util.List;

public class EventDaoRepository {
    private MutableLiveData<List<Event>> eventList;

    public EventDaoRepository() {
        eventList = new MutableLiveData<>();
    }

    public MutableLiveData<List<Event>> getEventLiveData(){
        return eventList;
    }

    public void add_event(String event_name) {
        Log.e("Event",event_name);
    }

    public void update_event(int event_id, String event_name) {
        Log.e("Event",event_name+" "+event_id);
    }

    public void search_event(String searchText) {
        Log.e("Event",searchText);
    }

    public void delete_event(int event_id){
        Log.e("Event",String.valueOf(event_id));
    }

    public void getAllEvents(){
        ArrayList<Event> list = new ArrayList<>();
        Event e1 = new Event(1,"Brush teeth");
        Event e2 = new Event(2,"Develop Project");
        Event e3 = new Event(3,"Go Walk");
        list.add(e1);
        list.add(e2);
        list.add(e3);
        eventList.setValue(list);

    }
}
