package com.tobetteryou.tobetterdo.viewmodels;

import androidx.lifecycle.ViewModel;

import com.tobetteryou.tobetterdo.repository.EventDaoRepository;

public class MainPageFragmentViewModel extends ViewModel {
    private EventDaoRepository eventDaoRepository = new EventDaoRepository();

    public void search(String event_name){
        eventDaoRepository.search_event(event_name);
    }
}
