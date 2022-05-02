package com.tobetteryou.tobetterdo.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.tobetteryou.tobetterdo.repository.EventDaoRepository;

public class AddToDoFragmentViewModel extends AndroidViewModel {
    private EventDaoRepository eventDaoRepository;

    public AddToDoFragmentViewModel(@NonNull Application application) {
        super(application);
        eventDaoRepository = new EventDaoRepository(application);
    }

    public void add(String event_name){
        eventDaoRepository.add_event(event_name);
    }
}
