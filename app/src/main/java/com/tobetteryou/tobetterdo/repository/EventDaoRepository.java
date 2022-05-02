package com.tobetteryou.tobetterdo.repository;

import android.util.Log;

public class EventDaoRepository {

    public void add_event(String event_name) {
        Log.e("Event",event_name);
    }

    public void update_event(int event_id, String event_name) {
        Log.e("Event",event_name+" "+event_id);
    }

    public void search_event(String searchText) {
        Log.e("Event",searchText);
    }
}
