package com.tobetteryou.tobetterdo.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tobetteryou.tobetterdo.entity.Event;
import com.tobetteryou.tobetterdo.repository.EventDaoRepository;

import java.util.List;

public class MainPageFragmentViewModel extends ViewModel {
    private EventDaoRepository eventDaoRepository = new EventDaoRepository();
    public MutableLiveData<List<Event>> eventList = new MutableLiveData<>();

    public MainPageFragmentViewModel() {
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
