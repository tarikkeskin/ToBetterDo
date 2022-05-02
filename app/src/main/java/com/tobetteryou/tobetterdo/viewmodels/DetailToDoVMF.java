package com.tobetteryou.tobetterdo.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

//View Model Factory
public class DetailToDoVMF extends ViewModelProvider.NewInstanceFactory {
    private final Application application;

    public DetailToDoVMF(Application application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new DetailToDoFragmentViewModel(application);
    }
}

