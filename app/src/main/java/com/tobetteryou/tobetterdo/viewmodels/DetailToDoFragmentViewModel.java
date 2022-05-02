package com.tobetteryou.tobetterdo.viewmodels;

import androidx.lifecycle.ViewModel;

import com.tobetteryou.tobetterdo.repository.EventDaoRepository;

public class DetailToDoFragmentViewModel extends ViewModel {
    private EventDaoRepository eventDaoRepository = new EventDaoRepository();

    public void update(int event_id,String event_name){
        eventDaoRepository.update_event(event_id,event_name);
    }
}
