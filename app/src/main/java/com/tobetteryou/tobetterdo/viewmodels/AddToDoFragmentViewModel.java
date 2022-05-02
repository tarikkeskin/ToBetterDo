package com.tobetteryou.tobetterdo.viewmodels;

import androidx.lifecycle.ViewModel;

import com.tobetteryou.tobetterdo.repository.EventDaoRepository;

public class AddToDoFragmentViewModel extends ViewModel {
    private EventDaoRepository eventDaoRepository = new EventDaoRepository();

    public void add(String event_name){
        eventDaoRepository.add_event(event_name);
    }
}
