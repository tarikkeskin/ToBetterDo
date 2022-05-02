package com.tobetteryou.tobetterdo.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.tobetteryou.tobetterdo.entity.Event;
import com.tobetteryou.tobetterdo.room.Database;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class EventDaoRepository {
    private MutableLiveData<List<Event>> eventList;
    private Database db;

    public EventDaoRepository(Application application) {
        eventList = new MutableLiveData<>();
        db = Database.databaseConnection(application);
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
        Disposable disposable = db.eventsDao().allEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    eventList.setValue(list);
                });
    }
}
