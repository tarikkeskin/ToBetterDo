package com.tobetteryou.tobetterdo.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tobetteryou.tobetterdo.entity.Event;
import com.tobetteryou.tobetterdo.repository.EventDaoRepository;

import java.util.List;

public class MainPageFragmentViewModel extends AndroidViewModel {
    private EventDaoRepository eventDaoRepository;
    public MutableLiveData<List<Event>> eventList = new MutableLiveData<>();

    public MainPageFragmentViewModel(@NonNull Application application) {
        super(application);
        eventDaoRepository = new EventDaoRepository(application);
        uploadEvents();
        eventList = eventDaoRepository.getEventLiveData();
    }

    public void uploadEvents(){
        eventDaoRepository.getAllEvents();
    }

    public void search(String event_name){
        eventDaoRepository.search_event(event_name);
    }

    public void delete(int event_id){
        eventDaoRepository.delete_event(event_id);
    }
}
