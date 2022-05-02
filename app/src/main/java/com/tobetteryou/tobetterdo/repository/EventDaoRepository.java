package com.tobetteryou.tobetterdo.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.tobetteryou.tobetterdo.entity.Event;
import com.tobetteryou.tobetterdo.room.Database;

import java.util.List;

import io.reactivex.CompletableObserver;
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
        Event new_event = new Event(0,event_name);
        db.eventsDao().insertEvent(new_event)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onComplete() {
                        Log.e("Event","Insert Successful");
                    }

                    @Override
                    public void onError(Throwable e) { }
                });
    }

    public void update_event(int event_id, String event_name) {
        Event event = new Event(event_id,event_name);
        db.eventsDao().updateEvent(event)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onComplete() {
                        Log.e("Event","Update Successful");
                    }

                    @Override
                    public void onError(Throwable e) { }
                });
    }

    public void search_event(String searchText) {
        Disposable disposable = db.eventsDao().searchEvent(searchText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    eventList.setValue(list);
                });
    }

    public void delete_event(int event_id){
        Event event = new Event(event_id,"");
        db.eventsDao().deleteEvent(event)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) { }

                    @Override
                    public void onComplete() {
                        Log.e("Event","Delete Successful");
                        getAllEvents();
                    }

                    @Override
                    public void onError(Throwable e) { }
                });

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
