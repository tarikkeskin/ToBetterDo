package com.tobetteryou.tobetterdo.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.tobetteryou.tobetterdo.repository.EventDaoRepository;

public class DetailToDoFragmentViewModel extends AndroidViewModel {
    private EventDaoRepository eventDaoRepository;

    public DetailToDoFragmentViewModel(@NonNull Application application) {
        super(application);
        eventDaoRepository = new EventDaoRepository(application);
    }

    public void update(int event_id, String event_name){
        eventDaoRepository.update_event(event_id,event_name);
    }
}
